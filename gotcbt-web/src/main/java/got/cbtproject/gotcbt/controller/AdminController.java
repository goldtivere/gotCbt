package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.command.SubjectCommand;
import got.cbtproject.gotcbt.command.TermCommand;
import got.cbtproject.gotcbt.enums.EntryType;
import got.cbtproject.gotcbt.enums.Student;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.repositories.SchoolClassRepository;
import got.cbtproject.gotcbt.repositories.SchoolGradeRepository;
import got.cbtproject.gotcbt.repositories.SchoolYearRepository;
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
    private final SchoolGradeRepository schoolGradeRepository;
    private final GlobalController globalController;
    private final SchoolYearRepository schoolYearRepository;

    public AdminController(StudentClassTypeService studentClassTypeService, SchoolClassRepository schoolClassRepository, SchoolGradeRepository schoolGradeRepository, GlobalController globalController, SchoolYearRepository schoolYearRepository) {
        this.studentClassTypeService = studentClassTypeService;
        this.schoolClassRepository = schoolClassRepository;
        this.schoolGradeRepository = schoolGradeRepository;
        this.globalController = globalController;
        this.schoolYearRepository = schoolYearRepository;
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
    public String subject(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("val",  schoolYearRepository.findAll());
        model.addAttribute("subCom", new SubjectCommand());
        model.addAttribute("dep",schoolClassRepository.findByIsdeleted(false));
        model.addAttribute("ent", EntryType.values());
        return "admin/subject";
    }

    @GetMapping("question")
    public String indexQuestion(Model model) {
        model.addAttribute("quest", new StudentGradeCommand());
        model.addAttribute("depts",schoolClassRepository.findByIsdeleted(false));
        return "admin/question";
    }

    @GetMapping("department")
    public String department(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("classAtt", new StudentGradeCommand());
        model.addAttribute("schlDept", new StudentGradeCommand());
        model.addAttribute("dept",schoolClassRepository.findByIsdeleted(false));

        return "admin/department";
    }

    @GetMapping("term")
    public String term(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("term", new TermCommand());
        model.addAttribute("dep",schoolClassRepository.findByIsdeleted(false));

        return "admin/term";
    }

    @GetMapping("findid")
    @ResponseBody
    public SchoolClass findid(Model model, Long id) {
        model.addAttribute("class1", new StudentClassCommand());
        return studentClassTypeService.findById(id);
    }

    @GetMapping("class")
    public String classGet(Model model, @RequestParam(defaultValue = "0") int page) {
        // PageRequest pageRequest=;
        model.addAttribute("schoolClass", new StudentClassCommand());
        model.addAttribute("tabVal",
                schoolClassRepository.findByIsdeleted(false, new PageRequest(page, 4)));
        model.addAttribute("currentPage", page);
        return "admin/class";
    }


}
