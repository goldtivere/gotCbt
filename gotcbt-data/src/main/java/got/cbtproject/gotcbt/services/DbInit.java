package got.cbtproject.gotcbt.services;

import org.springframework.stereotype.Service;

@Service
public class DbInit {
//implements CommandLineRunner
//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) {
//        // Delete all
//        this.userRepository.deleteAll();
//
//         //Crete users
//        Set<Role> roles = new HashSet<>();
//        Role role = new Role("ADMIN");
//        Role role1 = new Role("USER");
//        Role role2 = new Role("ADMIN");
//        roles.add(role);
//        Set<Role> roles1 = new HashSet<>();
//        Set<Role> roles2 = new HashSet<>();
//        roles1.add(role1);
//        roles1.add(role2);
//        Set<RolePermission> permissions = new HashSet<>();
//        permissions.add(RolePermission.READ);
//        Set<RolePermission> permissions1 = new HashSet<>();
//        permissions1.add(RolePermission.READ);
//        Set<RolePermission> permissions2 = new HashSet<>();
//        permissions2.add(RolePermission.READ);
//
////        List<Role> roles = new ArrayList<>();
////        Role role = new Role("ADMIN");
////        Role role1 = new Role("USER");
////        Role role2 = new Role("ADMIN");
////        roles.add(role);
////        List<Role> roles1 = new ArrayList<>();
////        List<Role> roles2 = new ArrayList<>();
////        roles1.add(role1);
////        roles1.add(role2);
////        List<RolePermission> permissions = new ArrayList<>();
////        permissions.add(RolePermission.READ);
////        List<RolePermission> permissions1 = new ArrayList<>();
////        permissions1.add(RolePermission.READ);
////        List<RolePermission> permissions2 = new ArrayList<>();
////        permissions2.add(RolePermission.READ);
//        Users dan = new Users("123", passwordEncoder.encode("2345"), 1, roles, permissions);
//
//        Users dans = new Users("234", passwordEncoder.encode("567"), 1, roles1, permissions1);
//
//        Users danss = new Users("2134", passwordEncoder.encode("2345"), 1, roles2, permissions2);
//
//        List<Users> users = Arrays.asList(dan, dans, danss);
//
//        // Save to db
//        this.userRepository.saveAll(users);
//    }
}
