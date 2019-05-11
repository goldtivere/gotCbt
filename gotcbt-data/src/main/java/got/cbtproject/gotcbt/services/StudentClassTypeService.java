package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.model.SchoolClass;

public interface StudentClassTypeService {
    StudentClassCommand save(StudentClassCommand schoolClass);
    StudentClassCommand delete(StudentClassCommand schoolClass);
//    List<SchoolClass> findByCreatedBy(Long createdBy, PageRequest pageRequest);

    SchoolClass findById(Long id);
}
