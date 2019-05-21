package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.repositories.SchoolClassRepository;
import got.cbtproject.gotcbt.repositories.SchoolGradeRepository;
import got.cbtproject.gotcbt.services.StudentClassTypeService;
import got.cbtproject.gotcbt.services.StudentGradeService;
import org.springframework.data.domain.PageRequest;
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

    public SchoolGradeController(StudentGradeService studentGradeService, StudentClassTypeService studentClassTypeService, GlobalController globalController, SchoolGradeRepository schoolGradeRepository, SchoolClassRepository schoolClassRepository) {
        this.studentGradeService = studentGradeService;
        this.studentClassTypeService = studentClassTypeService;
        this.globalController = globalController;
        this.schoolGradeRepository = schoolGradeRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    @PostMapping("/admin/Class/{operation}")
    public String saveTodo(@ModelAttribute("classAtt") StudentGradeCommand schoolClass, @PathVariable("operation") String operation,
                           final RedirectAttributes redirectAttributes) {
        // logger.info("/task/save");
        try {
            List<SchoolClass> schName = new ArrayList<>();

            System.out.println();
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
            }
//            } else if (operation.equals("update")) {
//                if (!updateClass.equals("") || updateClass != null) {
//                    String classType= updateClass.getClassType();
//                    updateClass = studentClassTypeCommand.convert(studentClassTypeService.findById(updateClass.getId()));
//                    updateClass.setClassType(classType);
//                    updateClass.setUpdatedBy(globalController.getLoginUser().getId());
//                    updateClass.setDateupdated(LocalDate.now());
//                    StudentClassCommand studentClassCommand2 = studentClassTypeService.save(updateClass);
//                    redirectAttributes.addFlashAttribute("msg", "update");
//                } else {
//                    redirectAttributes.addFlashAttribute("msg", "Please enter value in field!!");
//                }
//            } else {
//                redirectAttributes.addFlashAttribute("msg", "Invalid Command, Please try again!!");
//            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "exist");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", "exist");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "fail");
//            logger.error("save: " + e.getMessage());
        }

        return "redirect:/admin/department";
    }

    @RequestMapping("/admin/class/{dept}")
    public String singleEmployee(Model model, @PathVariable String dept, @RequestParam(defaultValue = "0") int page) {
        SchoolClass schoolClass1=studentClassTypeService.findByClassType(dept);
        List<SchoolGrade> allGrade = schoolGradeRepository.findByIsdeletedAndAndSchoolClass(false,schoolClass1,new PageRequest(page, 4));

        model.addAttribute("itemDetails",allGrade);
        return "fragments/classTab :: tabtab";

    }

//    @GetMapping("/admin/class/{employeeId}")
//    public String singleEmployee(Model model, @PathVariable String employeeId, @RequestParam(defaultValue = "0") int page) {
//        //instantiate the response object
//        Response response = new Response();
//
//        //set the employee to null
//        SchoolGrade returnedGrade = null;
//        SchoolClass schoolClass1=studentClassTypeService.findByClassType(employeeId);
//
//
//        //grab all employees
//        List<SchoolGrade> allGrade = schoolGradeRepository.findByIsdeletedAndAndSchoolClass(false,schoolClass1,new PageRequest(page, 4));
//
//        List<SchoolClass> schlAtt= allGrade.get(0).getSchoolClass();
//        model.addAttribute("tabVal1", schlAtt);
//        return "admin/department";
//    }

}
