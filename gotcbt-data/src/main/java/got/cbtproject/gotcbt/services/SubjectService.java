package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SubjectService {
    Subject findById(Long id);
    Subject save(Subject question);
    List<Subject> findAll();
}
