package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.services.StudentClassTypeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Getter
@Setter
public class StudentTypeClassController {
    private final StudentClassTypeService studentClassTypeService;
    private final GlobalController globalController;


    public StudentTypeClassController(StudentClassTypeService studentClassTypeService, GlobalController globalController) {
        this.studentClassTypeService = studentClassTypeService;
        this.globalController = globalController;
    }

    @PostMapping("/admin/schoolgroup/{operation}")
    public String saveTodo(@ModelAttribute("schoolClass") StudentClassCommand schoolClass,@PathVariable("operation") String operation,
                           final RedirectAttributes redirectAttributes) {
        // logger.info("/task/save");
        try {
            if(operation.equals("save")) {
                if (!schoolClass.equals("") || schoolClass != null) {
                    schoolClass.setCreatedBy(globalController.getLoginUser().getId());
                    StudentClassCommand studentClassCommand1 = studentClassTypeService.save(schoolClass);
                    redirectAttributes.addFlashAttribute("msg", "success");
                } else {
                    redirectAttributes.addFlashAttribute("msg", "Please enter value in field!!");
                }
            }
            else
            {
                redirectAttributes.addFlashAttribute("msg", "Invalid Command, Please try again!!");
            }
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", "exist");
        } catch (Exception e) {
//            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "fail");
//            logger.error("save: " + e.getMessage());
        }

        return "redirect:/admin/class";
    }

    @GetMapping("/admin/update/{id}")
    @ResponseBody
    public SchoolClass todoOperation(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {

        return studentClassTypeService.findById(id);
//            if (id == null || id.equals(null)) {
//                redirectAttributes.addFlashAttribute("msg", "notfound");
//            }

    }

}
