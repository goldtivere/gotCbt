package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.TermCommand;
import got.cbtproject.gotcbt.converters.TermToCommand;
import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.model.SchoolTerm;
import got.cbtproject.gotcbt.repositories.SchoolClassRepository;
import got.cbtproject.gotcbt.repositories.SchoolGradeRepository;
import got.cbtproject.gotcbt.repositories.SchoolTermRepository;
import got.cbtproject.gotcbt.services.StudentGradeService;
import got.cbtproject.gotcbt.services.StudentTermService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentTermController {
    private final SchoolGradeRepository schoolGradeRepository;
    private final SchoolTermRepository schoolTermRepository;
    private final StudentGradeService studentGradeService;
    private final StudentTermService studentTermService;
    private final GlobalController globalController;
    private final TermToCommand termToCommand;
    private final SchoolClassRepository schoolClassRepository;


    public StudentTermController(SchoolGradeRepository schoolGradeRepository, SchoolTermRepository schoolTermRepository, StudentGradeService studentGradeService, StudentTermService studentTermService, GlobalController globalController, TermToCommand termToCommand, SchoolClassRepository schoolClassRepository) {
        this.schoolGradeRepository = schoolGradeRepository;
        this.schoolTermRepository = schoolTermRepository;
        this.studentGradeService = studentGradeService;
        this.studentTermService = studentTermService;
        this.globalController = globalController;
        this.termToCommand = termToCommand;
        this.schoolClassRepository = schoolClassRepository;
    }

    @PostMapping("/admin/term/{operation}")
    public String saveTodo(@ModelAttribute("term") TermCommand termCommand,
                           @ModelAttribute("deptUpdate") TermCommand updateClass, @PathVariable("operation") String operation,
                           final RedirectAttributes redirectAttributes) {
        // logger.info("/task/save");
        try {
            List<SchoolGrade> schName = new ArrayList<>();

            if (operation.equals("save")) {
                if (!termCommand.getTerm().equals(null) || termCommand.getSchlDept() != null || termCommand.getSchoolGrade() != null) {
                    if (!termCommand.equals("") || termCommand != null) {
                        schName.add(studentGradeService.findByGradeName(Long.valueOf(termCommand.getSchlDept())));
                        termCommand.setSchoolGrades(schName);
                        termCommand.setCreatedBy(globalController.getLoginUser().getId());
                        termCommand.setDateCreated(LocalDate.now());
                        termCommand.setIsdeleted(false);

                        studentTermService.save(termCommand);
                        redirectAttributes.addFlashAttribute("msg", "success");
                    } else {
                        redirectAttributes.addFlashAttribute("msg", "Invalid Id");
                    }
                } else {
                    redirectAttributes.addFlashAttribute("msg", "classVal");
                }

            } else if (operation.equals("update")) {
                if (!updateClass.equals("") || updateClass != null) {
                    System.out.println("here i am ID: " + updateClass.getSchlDept()
                    );
                    schName.add(studentGradeService.findByGradeName(Long.valueOf(updateClass.getSchlDept())));
                    updateClass.setSchoolGrades(schName);
                    updateClass.setCreatedBy(globalController.getLoginUser().getId());
                    updateClass.setDateCreated(LocalDate.now());
                    updateClass.setIsdeleted(false);

                    studentTermService.save(updateClass);
                    redirectAttributes.addFlashAttribute("msg", "active");
                    redirectAttributes.addFlashAttribute("msgText", "update Successful!!");
                } else {
                    redirectAttributes.addFlashAttribute("msg", "Invalid Id");
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

        return "redirect:/admin/term";
    }

    @GetMapping("/admin/term/val/{item}")
    @ResponseBody
    public List<SchoolTerm> getAllTerm(@PathVariable("item") Long item) {
        System.out.println("Grade name: " + item);
        Map<String, Object> termAll = new HashMap<>();
        List<SchoolTerm> val = new ArrayList<>();
       SchoolGrade schoolGrade = studentGradeService.findByGradeName(item);
//        val = schoolTermRepository.findByIsdeletedAndSchoolGrades(false, schoolGrade);
//
//        for (SchoolTerm t : val) {
//            termAll.put("id", t.getId());
//            termAll.put("term", t.getTerm());
//        }

        return schoolTermRepository.findByIsdeletedAndSchoolGrades(false, schoolGrade);

    }

    @GetMapping("/admin/term/update/{id}")
    public String todoOperation(Model model, @PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {

        model.addAttribute("deptUpdates", termToCommand.convert(studentTermService.findById(id)));
        // model.addAttribute("deptVal", schoolClassRepository.findByIsdeleted(false));
        model.addAttribute("depss", studentGradeService.findById(studentTermService.findById(id).getSchoolGrades().get(0).getId()));

        model.addAttribute("dep", schoolClassRepository.findByIsdeleted(false));
        model.addAttribute("termEdit", new TermCommand());
//            if (id == null || id.equals(null)) {
//                redirectAttributes.addFlashAttribute("msg", "notfound");
//            }
        return "admin/termedit";
    }

    @GetMapping("/admin/term/delete/{id}")
    public String delete(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
        TermCommand updateClass = new TermCommand();
        if (id == null || id.equals(null)) {
            redirectAttributes.addFlashAttribute("msg", "active");
        }

        updateClass = termToCommand.convert(studentTermService.findById(id));
        updateClass.setDeletedBy(globalController.getLoginUser().getId());
        updateClass.setDateDeleted(LocalDate.now());
        updateClass.setIsdeleted(true);
        studentTermService.delete(updateClass);
        redirectAttributes.addFlashAttribute("msg", "delete");

        return "redirect:/admin/term";
    }
}
