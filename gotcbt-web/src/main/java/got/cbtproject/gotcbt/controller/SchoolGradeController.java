package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.converters.StudentGradeToCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.repositories.SchoolClassRepository;
import got.cbtproject.gotcbt.repositories.SchoolGradeRepository;
import got.cbtproject.gotcbt.services.StudentClassTypeService;
import got.cbtproject.gotcbt.services.StudentGradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SchoolGradeController {
    private final StudentGradeService studentGradeService;
    private final StudentClassTypeService studentClassTypeService;
    private final GlobalController globalController;
    private final SchoolGradeRepository schoolGradeRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final StudentGradeToCommand studentGradeToCommand;

    public SchoolGradeController(StudentGradeService studentGradeService, StudentClassTypeService studentClassTypeService, GlobalController globalController, SchoolGradeRepository schoolGradeRepository, SchoolClassRepository schoolClassRepository, StudentGradeToCommand studentGradeToCommand) {
        this.studentGradeService = studentGradeService;
        this.studentClassTypeService = studentClassTypeService;
        this.globalController = globalController;
        this.schoolGradeRepository = schoolGradeRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.studentGradeToCommand = studentGradeToCommand;
    }

    @PostMapping("/admin/department/{operation}")
    public String saveTodo(@ModelAttribute("classAtt") StudentGradeCommand schoolClass,
                           @ModelAttribute("deptUpdate") StudentGradeCommand updateClass, @PathVariable("operation") String operation,
                           final RedirectAttributes redirectAttributes) {
        // logger.info("/task/save");
        try {
            List<SchoolClass> schName = new ArrayList<>();

            if (operation.equals("save")) {
                if (!schoolClass.getSchoolClass().equals(null) || schoolClass.getSchoolClass() != null) {
                    if (!schoolClass.equals("") || schoolClass != null) {

                        schName.add(studentClassTypeService.findByClassType(schoolClass.getClassGrade().getClassType()));
                        schoolClass.setSchoolClass(schName);
                        schoolClass.setCreatedBy(globalController.getLoginUser().getId());
                        schoolClass.setDateCreated(LocalDate.now());
                        schoolClass.setIsdeleted(false);

                        studentGradeService.save(schoolClass);
                        redirectAttributes.addFlashAttribute("msg", "success");
                    } else {
                        redirectAttributes.addFlashAttribute("msg", "Invalid Id");
                    }
                } else {
                    redirectAttributes.addFlashAttribute("msg", "classVal");
                }

            } else if (operation.equals("update")) {
                if (!updateClass.equals("") || updateClass != null) {
                    schName.add(studentClassTypeService.findByClassType(updateClass.getClassGrade().getClassType()));
                    updateClass.setSchoolClass(schName);
                    updateClass.setCreatedBy(globalController.getLoginUser().getId());
                    updateClass.setDateCreated(LocalDate.now());
                    updateClass.setIsdeleted(false);
                    studentGradeService.save(updateClass);
                    redirectAttributes.addFlashAttribute("msg", "success");
                } else {
                    redirectAttributes.addFlashAttribute("msg", "Please enter value in field!!");
                }
            } else {
                redirectAttributes.addFlashAttribute("msg", "Invalid Command, Please try again!!");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "exist");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", "active");
            redirectAttributes.addFlashAttribute("msgText", e.getMessage());


        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "fail");
//            logger.error("save: " + e.getMessage());
        }

        return "redirect:/admin/department";
    }


//    @GetMapping("/admin/department/{dept}")
//    public String singleEmployee(Model model, @PathVariable("dept") String dept, @RequestParam(defaultValue = "0") int page) {
//        SchoolClass schoolClass1 = studentClassTypeService.findByClassType(dept);
//        List<SchoolGrade> allGrade = schoolGradeRepository.findByIsdeletedAndAndSchoolClass(false, schoolClass1, new PageRequest(page, 4));
//
//        model.addAttribute("itemDetails", allGrade);
//        model.addAttribute("schlDept", new StudentGradeCommand());
//        return "fragments/classTab :: tabtab";
//
//    }

    @GetMapping("/admin/department/val/{item}")
    @ResponseBody
    public List<SchoolGrade> getAllEmployees(@PathVariable("item") String item) {
        SchoolClass schoolClass1 = studentClassTypeService.findByClassType(item);
        return schoolGradeRepository.findByIsdeletedAndAndSchoolClass(false, schoolClass1);

    }

    @GetMapping("/admin/department/update/{id}")
    public String todoOperation(Model model, @PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {

        model.addAttribute("deptUpdate", studentGradeToCommand.convert(studentGradeService.findById(id)));
        model.addAttribute("deptVal", schoolClassRepository.findByIsdeleted(false));
//            if (id == null || id.equals(null)) {
//                redirectAttributes.addFlashAttribute("msg", "notfound");
//            }
        return "admin/editClass";
    }


    @GetMapping("/admin/department/delete/{id}")
    public String delete(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
        StudentGradeCommand updateClass = new StudentGradeCommand();
        if (id == null || id.equals(null)) {
            redirectAttributes.addFlashAttribute("msg", "active");
        }

        updateClass = studentGradeToCommand.convert(studentGradeService.findById(id));
        updateClass.setDeletedBy(globalController.getLoginUser().getId());
        updateClass.setDateDeleted(LocalDate.now());
        updateClass.setIsdeleted(true);
        studentGradeService.delete(updateClass);
        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/admin/department";
    }
}
