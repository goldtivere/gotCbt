package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.command.StudentGradeCommand;


public interface StudentGradeService {
    StudentGradeCommand save(StudentGradeCommand schoolClass);
}
