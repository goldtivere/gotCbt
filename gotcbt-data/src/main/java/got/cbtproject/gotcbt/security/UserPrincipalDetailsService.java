package got.cbtproject.gotcbt.security;

import got.cbtproject.gotcbt.model.Users;
import got.cbtproject.gotcbt.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       // LoginCommand loginCommand = new LoginCommand();
        Users user = this.userRepository.findByUserId(s);
//        Role role= new Role();
//        user.getRole().forEach(r -> {
//             role.setRole(r.getRole());
//        });
//
//        loginCommand.setUserId(user.getUserId());
//        loginCommand.setPassword(user.getPassword());
//        loginCommand.setPermission(user.getPermissions().toString());
//        loginCommand.setRole(role.getRole());
//
//
//
//
//        //get string value of role and permission


        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }
}
