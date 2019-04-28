package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.model.SchoolClass;

import java.util.List;

public interface StudentClassTypeService {
    StudentClassCommand save(StudentClassCommand schoolClass);

    List<SchoolClass> findByCreatedBy(int createdBy);
}
