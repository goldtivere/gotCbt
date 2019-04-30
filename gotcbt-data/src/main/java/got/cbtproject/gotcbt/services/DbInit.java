package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.enums.RolePermission;
import got.cbtproject.gotcbt.model.Role;
import got.cbtproject.gotcbt.model.Users;
import got.cbtproject.gotcbt.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

         //Crete users
        Set<Role> roles = new HashSet<>();
        Role role = new Role("ADMIN");
        Role role1 = new Role("USER");
        Role role2 = new Role("ADMIN");
        roles.add(role);
        Set<Role> roles1 = new HashSet<>();
        Set<Role> roles2 = new HashSet<>();
        roles1.add(role1);
        roles1.add(role2);
        Set<RolePermission> permissions = new HashSet<>();
        permissions.add(RolePermission.READ);
        Set<RolePermission> permissions1 = new HashSet<>();
        permissions1.add(RolePermission.READ);
        Set<RolePermission> permissions2 = new HashSet<>();
        permissions2.add(RolePermission.READ);

//        List<Role> roles = new ArrayList<>();
//        Role role = new Role("ADMIN");
//        Role role1 = new Role("USER");
//        Role role2 = new Role("ADMIN");
//        roles.add(role);
//        List<Role> roles1 = new ArrayList<>();
//        List<Role> roles2 = new ArrayList<>();
//        roles1.add(role1);
//        roles1.add(role2);
//        List<RolePermission> permissions = new ArrayList<>();
//        permissions.add(RolePermission.READ);
//        List<RolePermission> permissions1 = new ArrayList<>();
//        permissions1.add(RolePermission.READ);
//        List<RolePermission> permissions2 = new ArrayList<>();
//        permissions2.add(RolePermission.READ);
        Users dan = new Users("123", passwordEncoder.encode("2345"), 1, roles, permissions, LocalDate.now(), Long.valueOf(1));

        Users dans = new Users("234", passwordEncoder.encode("567"), 1, roles1, permissions1, LocalDate.now(), Long.valueOf(2));

        Users danss = new Users("2134", passwordEncoder.encode("2345"), 1, roles2, permissions2, LocalDate.now(), Long.valueOf(1));

        List<Users> users = Arrays.asList(dan, dans, danss);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
