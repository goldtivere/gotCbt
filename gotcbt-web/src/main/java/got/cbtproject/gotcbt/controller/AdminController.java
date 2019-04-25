package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.enums.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {


    @GetMapping("student")
    public String student(Model model) {
        model.addAttribute("student", Student.values());
        return "admin/student";
    }

    @GetMapping("setting")
    public String setting() {
        return "admin/setting";
    }

    @GetMapping("subject")
    public String subject() {
        return "admin/subject";
    }

    @GetMapping("question")
    public String indexQuestion() {
        return "admin/question";
    }

    @GetMapping("class")
    public String classGet(Model model) {
        model.addAttribute("schoolClass", new StudentClassCommand());
        return "admin/class";
    }


}
