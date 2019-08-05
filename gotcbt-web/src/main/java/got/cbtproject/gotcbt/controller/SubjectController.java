package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.command.SubjectCommand;
import got.cbtproject.gotcbt.model.Subject;
import got.cbtproject.gotcbt.repositories.SubjectRepo;
import got.cbtproject.gotcbt.services.*;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SubjectController {

    private final StudentGradeService studentGradeService;
    private final StudentTermService studentTermService;
    private final SchoolYearService schoolYearService;
    private final GlobalController globalController;
    private final SubjectService subjectService;
    private final SubjectRepo subjectRepo;
    private final ExcelUploadService excelUploadService;

    public SubjectController(StudentGradeService studentGradeService, StudentTermService studentTermService, SchoolYearService schoolYearService, GlobalController globalController, SubjectService subjectService, SubjectRepo subjectRepo, ExcelUploadService excelUploadService) {
        this.studentGradeService = studentGradeService;
        this.studentTermService = studentTermService;
        this.schoolYearService = schoolYearService;
        this.globalController = globalController;
        this.subjectService = subjectService;
        this.subjectRepo = subjectRepo;
        this.excelUploadService = excelUploadService;
    }

    @GetMapping("/admin/subject/val/{item}")
    @ResponseBody
    public List<Subject> getAllEmployees(@PathVariable("item") Long item) {
        //SchoolGrade schoolGrade = studentGradeService.findByGradeName(item);
        List<Subject> me = new ArrayList<>();
        return me;
//        return schoolTermRepository.findByIsdeletedAndSchoolGrades(false, schoolGrade);

    }

    @PostMapping("/admin/subject/{operation}")
    public String saveTodo(MultipartFile file,@ModelAttribute("subCom") SubjectCommand sub,
                           @ModelAttribute("deptUpdate") SubjectCommand subject, @PathVariable("operation") String operation,
                           final RedirectAttributes redirectAttributes) {
        // logger.info("/task/save");
        try {


            if (operation.equals("save")) {
                if (!sub.getSchoolGrade().equals(null) || sub.getSchoolTerm() != null || sub.getSubjectYear() != null) {
                    if (!sub.equals("") || sub != null) {
                        if(sub.getEntryType().equalsIgnoreCase("entry")) {
                            System.out.println("Hello " + sub.getSchoolGrade() + "  yyyyyy  " + studentGradeService.findByGradeName(Long.valueOf(sub.getSchoolGrade())).getGrade());
                            sub.setSchoolGrade1(studentGradeService.findByGradeName(Long.valueOf(sub.getSchoolGrade())).getId());
                            sub.setYear(schoolYearService.findByYear(Long.valueOf(sub.getSubjectYear())).getId());
                            sub.setTerm(studentTermService.findById(Long.valueOf(sub.getSchoolTerm())).getId());
                            sub.setCreatedBy(globalController.getLoginUser().getId());
                            sub.setDateCreated(LocalDate.now());
                            sub.setIsdeleted(false);


                            subjectService.save(sub);
                            redirectAttributes.addFlashAttribute("msg", "active");
                            redirectAttributes.addFlashAttribute("msgText", "Subject Saved Successfully!!");
                        }
                        else if(sub.getEntryType().equalsIgnoreCase("upload"))
                        {
                            List<String> subjectHolder= new ArrayList<>();
                            InputStream in = file.getInputStream();
                            File currDir = new File(file.getOriginalFilename());
                            OPCPackage pkg = OPCPackage.open(in);
                            XSSFWorkbook wb = new XSSFWorkbook(pkg);

                            subjectHolder= (List<String>) excelUploadService.workBook(wb);

                            for(String subj: subjectHolder)
                            {
                                sub.setSubjectName(subj);
                                sub.setSchoolGrade1(studentGradeService.findByGradeName(Long.valueOf(sub.getSchoolGrade())).getId());
                                sub.setYear(schoolYearService.findByYear(Long.valueOf(sub.getSubjectYear())).getId());
                                sub.setTerm(studentTermService.findById(Long.valueOf(sub.getSchoolTerm())).getId());
                                sub.setCreatedBy(globalController.getLoginUser().getId());
                                sub.setDateCreated(LocalDate.now());
                                sub.setIsdeleted(false);


                                subjectService.save(sub);
                                System.out.println("and subjects are: "+ subj);
                            }
                            pkg.close();
                            redirectAttributes.addFlashAttribute("msg", "active");
                            redirectAttributes.addFlashAttribute("msgText", "Subject Uploaded Successfully!!");
                        }

                    } else {
                        redirectAttributes.addFlashAttribute("msg", "Invalid Id");
                    }
                } else {
                    redirectAttributes.addFlashAttribute("msg", "classVal");
                }

            }
//            else if (operation.equals("update")) {
//                if (!updateClass.equals("") || updateClass != null) {
//                    System.out.println("here i am ID: " + updateClass.getSchlDept()
//                    );
//                    schName.add(studentGradeService.findByGradeName(Long.valueOf(updateClass.getSchlDept())));
//                    updateClass.setSchoolGrades(schName);
//                    updateClass.setCreatedBy(globalController.getLoginUser().getId());
//                    updateClass.setDateCreated(LocalDate.now());
//                    updateClass.setIsdeleted(false);
//
//                    studentTermService.save(updateClass);
//                    redirectAttributes.addFlashAttribute("msg", "active");
//                    redirectAttributes.addFlashAttribute("msgText", "update Successful!!");
//                } else {
//                    redirectAttributes.addFlashAttribute("msg", "Invalid Id");
//                }
//            } else {
//                redirectAttributes.addFlashAttribute("msg", "Invalid Command, Please try again!!");
//            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "exist");
        } catch (RuntimeException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "active");
            redirectAttributes.addFlashAttribute("msgText", e.getMessage());


        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "fail");
//            logger.error("save: " + e.getMessage());
        }

        return "redirect:/admin/subject";
    }

    @GetMapping("/admin/subject/term/{term}/{year}/{dept}")
    @ResponseBody
    public List<Subject> getSubject(@PathVariable("term") Long item, @PathVariable("year") Long sYear, @PathVariable("dept") Long dept) {
        //SchoolGrade schoolGrade = studentGradeService.findByGradeName(item);


        if (item == null || sYear == null || dept == null || item.equals(null) || sYear.equals(null) || dept.equals(null)) {
            throw new RuntimeException("Subject doesnt exist!");
        }

        return subjectService.findSubject(item, sYear, dept);
//        return schoolTermRepository.findByIsdeletedAndSchoolGrades(false, schoolGrade);

    }
}
