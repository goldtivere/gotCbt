package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.message.Response;
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

    @ResponseBody
    @RequestMapping("/admin/class/{employeeId}")
    public List<Response> singleEmployee(Model model, @PathVariable String employeeId, @RequestParam(defaultValue = "0") int page) {
        //instantiate the response object
        Response response = new Response();

        //set the employee to null
        List<SchoolGrade> returnedGrade = new ArrayList<>();
        List<Response> returnedResponse = new ArrayList<>();
        SchoolClass schoolClass1=studentClassTypeService.findByClassType(employeeId);


        //grab all employees
        List<SchoolGrade> allGrade = schoolGradeRepository.findByIsdeletedAndAndSchoolClass(false,schoolClass1,new PageRequest(page, 4));
        //look for a match
        for (SchoolGrade employee : allGrade) {

            for(SchoolClass schoolClass: employee.getSchoolClass())
            {
                if (schoolClass.getClassType().equals(employeeId)) {
                    returnedGrade.add(employee);
                    break;
                }
            }
//            if (employee.getSchoolClass()..equals(employeeId)) {
//                returnedGrade = employee;
//                break;
//            }
        }

        if (returnedGrade == null) {
            //the URL contains an unknown employee id - we'll return an empty response
            response.setResponseStatus(Response.NOT_FOUND);
            response.setResponse("");
            returnedResponse.add(response);
        } else {
            //good response if we get here
            System.out.println(returnedGrade.get(0).getGrade() + " equals "+ returnedGrade.get(0).getSchoolClass().get(0).getClassType());
            response.setResponseStatus(Response.OK);
            response.setResponse(returnedGrade);
            returnedResponse.add(response);
            System.out.println(returnedGrade.get(1).getGrade() + " plus ");
        }

        return returnedResponse;
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
