package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.model.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubjectController {

    @GetMapping("/admin/subject/val/{item}")
    @ResponseBody
    public List<Subject> getAllEmployees(@PathVariable("item") Long item) {
        //SchoolGrade schoolGrade = studentGradeService.findByGradeName(item);
        List<Subject> me= new ArrayList<>();
        return me;
//        return schoolTermRepository.findByIsdeletedAndSchoolGrades(false, schoolGrade);

    }

}
