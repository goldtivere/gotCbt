package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.converters.StudentClassTypeCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.repositories.SchoolClassRepository;
import got.cbtproject.gotcbt.services.StudentClassTypeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Getter
@Setter
public class StudentTypeClassController {
    private final StudentClassTypeService studentClassTypeService;
    private final GlobalController globalController;
    private final SchoolClassRepository schoolClassRepository;

    public StudentTypeClassController(StudentClassTypeService studentClassTypeService, GlobalController globalController, SchoolClassRepository schoolClassRepository) {
        this.studentClassTypeService = studentClassTypeService;
        this.globalController = globalController;
        this.schoolClassRepository = schoolClassRepository;
    }

    @PostMapping("/admin/schoolgroup/{operation}")
    public String saveTodo(@ModelAttribute("schoolClass") StudentClassCommand schoolClass, @ModelAttribute("updateClass") StudentClassCommand updateClass, @PathVariable("operation") String operation,
                           final RedirectAttributes redirectAttributes) {
        // logger.info("/task/save");
        try {
            StudentClassTypeCommand studentClassTypeCommand = new StudentClassTypeCommand();
            if (operation.equals("save")) {
                if (!schoolClass.equals("") || schoolClass != null) {
                    schoolClass.setCreatedBy(globalController.getLoginUser().getId());
                    schoolClass.setDateCreated(LocalDate.now());
                    schoolClass.setIsdeleted(false);
                    StudentClassCommand studentClassCommand1 = studentClassTypeService.save(schoolClass);
                    redirectAttributes.addFlashAttribute("msg", "success");
                } else {
                    redirectAttributes.addFlashAttribute("msg", "Invalid Id");
                }
            } else if (operation.equals("update")) {
                if (!updateClass.equals("") || updateClass != null) {
                    String classType= updateClass.getClassType();
                    updateClass = studentClassTypeCommand.convert(studentClassTypeService.findById(updateClass.getId()));
                    updateClass.setClassType(classType);
                    updateClass.setUpdatedBy(globalController.getLoginUser().getId());
                    updateClass.setDateupdated(LocalDate.now());
                    StudentClassCommand studentClassCommand2 = studentClassTypeService.save(updateClass);
                    redirectAttributes.addFlashAttribute("msg", "update");
                } else {
                    redirectAttributes.addFlashAttribute("msg", "Please enter value in field!!");
                }
            } else {
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

    @GetMapping("/admin/schoolGroup/delete/{id}")
    public String delete(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
        StudentClassTypeCommand studentClassTypeCommand = new StudentClassTypeCommand();
        StudentClassCommand updateClass = new StudentClassCommand();
        if (id == null || id.equals(null)) {
            redirectAttributes.addFlashAttribute("msg", "active");
        }

        updateClass = studentClassTypeCommand.convert(studentClassTypeService.findById(id));
        updateClass.setDeletedBy(globalController.getLoginUser().getId());
        updateClass.setDateDeleted(LocalDate.now());
        updateClass.setIsdeleted(true);
        studentClassTypeService.delete(updateClass);
        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/admin/class";
    }

}
