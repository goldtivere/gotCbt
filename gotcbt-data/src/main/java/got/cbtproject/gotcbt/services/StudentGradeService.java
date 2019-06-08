package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.model.SchoolGrade;

import java.util.List;


public interface StudentGradeService {
    StudentGradeCommand save(StudentGradeCommand schoolClass);
    //SchoolGrade findBySchoolClassType(SchoolClass classType, Pageable pageable);
   List<SchoolGrade> findBySchoolClassType(SchoolClass classType);
    SchoolGrade findById(Long id);
    SchoolGrade findByGradeName(Long name);
    StudentGradeCommand delete(StudentGradeCommand schoolClass);
}
