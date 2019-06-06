package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.model.SchoolGrade;


public interface StudentGradeService {
    StudentGradeCommand save(StudentGradeCommand schoolClass);
    //SchoolGrade findBySchoolClassType(SchoolClass classType, Pageable pageable);
    SchoolGrade findById(Long id);
    SchoolGrade findByGradeName(Long name);
    StudentGradeCommand delete(StudentGradeCommand schoolClass);
}
