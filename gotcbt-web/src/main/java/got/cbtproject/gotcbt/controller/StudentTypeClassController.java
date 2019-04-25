package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.services.StudentClassTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentTypeClassController {
    private final StudentClassTypeService studentClassTypeService;

    public StudentTypeClassController(StudentClassTypeService studentClassTypeService) {
        this.studentClassTypeService = studentClassTypeService;
    }

    @PostMapping("/admin/schoolgroup/save")
    public String saveTodo(@ModelAttribute("schoolClass") StudentClassCommand schoolClass,
                           final RedirectAttributes redirectAttributes) {
        // logger.info("/task/save");
        try {
            StudentClassCommand studentClassCommand1=studentClassTypeService.save(schoolClass);
            redirectAttributes.addFlashAttribute("msg", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "fail");
//            logger.error("save: " + e.getMessage());
        }

        return "redirect:/admin/class";
    }
}
