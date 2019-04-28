package got.cbtproject.gotcbt.services.impl;

import got.cbtproject.gotcbt.converters.LoginCommandToUser;
import got.cbtproject.gotcbt.converters.UserToLoginCommand;
import got.cbtproject.gotcbt.model.Users;
import got.cbtproject.gotcbt.repositories.UserRepository;
import got.cbtproject.gotcbt.services.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UsersService {
    private final UserRepository userRepository;
    private final LoginCommandToUser loginCommandToUser;
    private final UserToLoginCommand userToLoginCommand;

    public UserServiceImpl(UserRepository userRepository, LoginCommandToUser loginCommandToUser, UserToLoginCommand userToLoginCommand) {
        this.userRepository = userRepository;
        this.loginCommandToUser = loginCommandToUser;
        this.userToLoginCommand = userToLoginCommand;
    }

    @Override
    public Users findByUserId(String id) {
        return userRepository.findByUserId(id);
    }

//    @Override
//    public LoginCommand findUsernameAndPassword(LoginCommand loginCommand) {
//        Optional<Users> users = userRepository.findByUserIdAndPassword(loginCommand.getUserId(), loginCommand.getPassword());
//
//        if(users.isPresent() )
//        {
//            System.out.println(users.get().getUserId()+ "*********"+ users.get().getPassword()+ " i am here");
//            return userToLoginCommand.convert(users.get());
//
//        }
//        throw new RuntimeException("Username or Password mismatch!");
//    }
}
