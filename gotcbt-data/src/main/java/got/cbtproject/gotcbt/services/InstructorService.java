package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.model.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor findById(Long id);
    Instructor save(Instructor instructor);
    List<Instructor> findAll();
}
