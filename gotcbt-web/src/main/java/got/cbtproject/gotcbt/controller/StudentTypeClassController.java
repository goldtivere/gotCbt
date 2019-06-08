package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.converters.StudentClassTypeCommand;
import got.cbtproject.gotcbt.converters.StudentGradeToCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.repositories.SchoolClassRepository;
import got.cbtproject.gotcbt.repositories.SchoolGradeRepository;
import got.cbtproject.gotcbt.services.StudentClassTypeService;
import got.cbtproject.gotcbt.services.StudentGradeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@Getter
@Setter
public class StudentTypeClassController {
    private final StudentClassTypeService studentClassTypeService;
    private final GlobalController globalController;
    private final SchoolClassRepository schoolClassRepository;
    private final StudentClassTypeCommand studentClassTypeCommand;
    private final StudentGradeService studentGradeService;
    private  final SchoolGradeRepository schoolGradeRepository;
    private  final StudentGradeToCommand studentGradeToCommand;

    public StudentTypeClassController(StudentClassTypeService studentClassTypeService, GlobalController globalController, SchoolClassRepository schoolClassRepository, StudentClassTypeCommand studentClassTypeCommand, StudentGradeService studentGradeService, SchoolGradeRepository schoolGradeRepository, StudentGradeToCommand studentGradeToCommand) {
        this.studentClassTypeService = studentClassTypeService;
        this.globalController = globalController;
        this.schoolClassRepository = schoolClassRepository;
        this.studentClassTypeCommand = studentClassTypeCommand;
        this.studentGradeService = studentGradeService;
        this.schoolGradeRepository = schoolGradeRepository;
        this.studentGradeToCommand = studentGradeToCommand;
    }

    @PostMapping("/admin/schoolgroup/{operation}")
    public String saveTodo(@ModelAttribute("schoolClass") StudentClassCommand schoolClass, @ModelAttribute("editClass") StudentClassCommand updateClass, @PathVariable("operation") String operation,
                           final RedirectAttributes redirectAttributes) {
        // logger.info("/task/save");
        try {
            StudentClassTypeCommand studentClassTypeCommand = new StudentClassTypeCommand();
            if (operation.equals("save")) {
                if (!schoolClass.equals("") || schoolClass != null) {
                    schoolClass.setCreatedBy(globalController.getLoginUser().getId());
                    schoolClass.setDateCreated(LocalDate.now());
                    schoolClass.setIsdeleted(false);
                    studentClassTypeService.save(schoolClass);
                    redirectAttributes.addFlashAttribute("msg", "success");
                } else {
                    redirectAttributes.addFlashAttribute("msg", "Invalid Id");
                }
            } else if (operation.equals("update")) {
                if (!updateClass.equals("") || updateClass != null) {
                    String classType = updateClass.getClassType();

                    updateClass = studentClassTypeCommand.convert(studentClassTypeService.findById(updateClass.getId()));
                    updateClass.setClassType(classType);
                    updateClass.setUpdatedBy(globalController.getLoginUser().getId());
                    updateClass.setDateupdated(LocalDate.now());
                    System.out.println(updateClass.getClassType()+ " this is it again "+ updateClass.getDateCreated());
                   studentClassTypeService.save(updateClass);
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
    public String todoOperation(Model model, @PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
        model.addAttribute("editClass",studentClassTypeCommand.convert(studentClassTypeService.findById(id)) );
            if (id == null || id.equals(null)) {
                redirectAttributes.addFlashAttribute("msg", "notfound");
            }
        return "admin/edit";


    }

    @GetMapping("/admin/schoolGroup/delete/{id}")
    public String delete(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
        StudentClassTypeCommand studentClassTypeCommand = new StudentClassTypeCommand();
        StudentClassCommand updateClass = new StudentClassCommand();
        StudentGradeCommand updateClass1 = new StudentGradeCommand();
        SchoolClass val=studentClassTypeService.findByClassType(id);
        System.out.println(val.getClassType()+ val.getId()+ " t is well");
        List<SchoolGrade> valu= schoolGradeRepository.findByIsdeletedAndSchoolClass(false, val);
        if (id == null || id.equals(null)) {
            redirectAttributes.addFlashAttribute("msg", "active");
        }

        for(SchoolGrade c: valu)
        {
            updateClass1 = studentGradeToCommand.convert(c);
            updateClass1.setDeletedBy(globalController.getLoginUser().getId());
            updateClass1.setDateDeleted(LocalDate.now());
            updateClass1.setIsdeleted(true);
            studentGradeService.delete(updateClass1);
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
