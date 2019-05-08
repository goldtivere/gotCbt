package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.enums.Student;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.services.StudentClassTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin")
public class AdminController {
    private final StudentClassTypeService studentClassTypeService;
    private final GlobalController globalController;

    public AdminController(StudentClassTypeService studentClassTypeService, GlobalController globalController) {
        this.studentClassTypeService = studentClassTypeService;
        this.globalController = globalController;
    }

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

    @GetMapping("findid")
    @ResponseBody
    public SchoolClass findid(Model model,Long id) {
        model.addAttribute("class1", new StudentClassCommand());
        return studentClassTypeService.findById(id);
    }

    @GetMapping("class")
    public String classGet(Model model) {
        model.addAttribute("schoolClass", new StudentClassCommand());
        System.out.println(globalController.getLoginUser().getId() + " ****");
        model.addAttribute("tabVal", studentClassTypeService.findByCreatedBy(globalController.getLoginUser().getId()));
        return "admin/class";
    }


}
