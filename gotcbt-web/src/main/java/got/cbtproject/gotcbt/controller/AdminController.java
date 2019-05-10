package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.enums.Student;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.repositories.SchoolClassRepository;
import got.cbtproject.gotcbt.services.StudentClassTypeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin")
public class AdminController {
    private final StudentClassTypeService studentClassTypeService;
    private final SchoolClassRepository schoolClassRepository;
    private final GlobalController globalController;

    public AdminController(StudentClassTypeService studentClassTypeService, SchoolClassRepository schoolClassRepository, GlobalController globalController) {
        this.studentClassTypeService = studentClassTypeService;
        this.schoolClassRepository = schoolClassRepository;
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
    public String classGet(Model model,@RequestParam(defaultValue = "0") int page) {
       // PageRequest pageRequest=;
        model.addAttribute("schoolClass", new StudentClassCommand());
        model.addAttribute("updateClass", new StudentClassCommand());
        model.addAttribute("tabVal",
                schoolClassRepository.findByCreatedBy(globalController.getLoginUser().getId(),new PageRequest(page,4)));
        model.addAttribute("currentPage", page);
        return "admin/class";
    }


}
