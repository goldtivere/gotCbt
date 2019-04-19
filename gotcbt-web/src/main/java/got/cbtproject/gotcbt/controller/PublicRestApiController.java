package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.model.Users;
import got.cbtproject.gotcbt.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
    private UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

    @GetMapping("users")
    public Iterable<Users> users(){
        return this.userRepository.findAll();
    }

}
