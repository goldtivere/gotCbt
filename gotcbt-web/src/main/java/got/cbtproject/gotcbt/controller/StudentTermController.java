package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.model.SchoolTerm;
import got.cbtproject.gotcbt.repositories.SchoolGradeRepository;
import got.cbtproject.gotcbt.repositories.SchoolTermRepository;
import got.cbtproject.gotcbt.services.StudentGradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentTermController {
    private final SchoolGradeRepository schoolGradeRepository;
    private final SchoolTermRepository schoolTermRepository;
    private final StudentGradeService studentGradeService;

    public StudentTermController(SchoolGradeRepository schoolGradeRepository, SchoolTermRepository schoolTermRepository, StudentGradeService studentGradeService) {
        this.schoolGradeRepository = schoolGradeRepository;
        this.schoolTermRepository = schoolTermRepository;
        this.studentGradeService = studentGradeService;
    }

    @GetMapping("/admin/term/val/{item}")
    @ResponseBody
    public List<SchoolTerm> getAllEmployees(@PathVariable("item") String item) {
        SchoolGrade schoolGrade = studentGradeService.findByGradeName(item);
        return schoolTermRepository.findByIsdeletedAndSchoolGrades(false, schoolGrade);

    }
}
