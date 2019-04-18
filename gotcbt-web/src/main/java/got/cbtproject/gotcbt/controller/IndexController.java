package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.LoginCommand;
import got.cbtproject.gotcbt.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
    private final UsersService usersService;

    public IndexController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("users", new LoginCommand());
        return "index";

    }

    @GetMapping
    @RequestMapping({"/dashboard"})
    public String getDashBoard() {

        return "/dashboard/index";
    }

    @PostMapping("/index")
    public String login(@ModelAttribute LoginCommand command) {
        //LoginCommand savedCommand = usersService.findUsernameAndPassword(command);
        System.out.println(command.getPassword() + " ****** " + command.getUserId());
        return "singnup";
    }
}