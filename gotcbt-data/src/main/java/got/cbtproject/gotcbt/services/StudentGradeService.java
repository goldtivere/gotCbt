package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.model.SchoolGrade;


public interface StudentGradeService {
    StudentGradeCommand save(StudentGradeCommand schoolClass);
    //SchoolGrade findBySchoolClassType(SchoolClass classType, Pageable pageable);
    SchoolGrade findById(Long id);
    StudentGradeCommand delete(StudentGradeCommand schoolClass);
}
