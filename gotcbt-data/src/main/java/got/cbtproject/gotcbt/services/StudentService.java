package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.model.Student;

import java.util.List;

public interface StudentService {

    Student findByLastName(String lastName);
    Student findById(Long id);
    Student save(Student student);
    List<Student> findAll();
}
