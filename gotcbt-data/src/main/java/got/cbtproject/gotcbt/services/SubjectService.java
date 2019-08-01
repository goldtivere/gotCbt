package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.command.SubjectCommand;
import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SubjectService {
    Subject findById(Long id);
    SubjectCommand save(SubjectCommand question);
    List<Subject> findSubject(Long term,Long year,Long dept);
    SchoolGrade findById(SchoolGrade grade);

}
