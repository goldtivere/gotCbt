package got.cbtproject.gotcbt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("student")
    public String student(){
        return "admin/student";
    }

    @GetMapping("setting")
    public String setting(){
        return "admin/setting";
    }

    @GetMapping("subject")
    public String subject(){
        return "admin/subject";
    }

    @GetMapping("question")
    public String index(){
        return "admin/question";
    }
}
