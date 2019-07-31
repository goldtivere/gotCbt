package got.cbtproject.gotcbt.services.impl;

import got.cbtproject.gotcbt.command.SubjectCommand;
import got.cbtproject.gotcbt.converters.CommandToSubject;
import got.cbtproject.gotcbt.converters.SubjectToCommand;
import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.model.Subject;
import got.cbtproject.gotcbt.repositories.SubjectRepo;
import got.cbtproject.gotcbt.services.StudentGradeService;
import got.cbtproject.gotcbt.services.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectToCommand subjectToCommand;
    private final CommandToSubject commandToSubject;
    private final SubjectRepo subjectRepo;
    private final StudentGradeService studentGradeService;

    public SubjectServiceImpl(SubjectToCommand subjectToCommand, CommandToSubject commandToSubject, SubjectRepo subjectRepo, StudentGradeService studentGradeService) {
        this.subjectToCommand = subjectToCommand;
        this.commandToSubject = commandToSubject;
        this.subjectRepo = subjectRepo;
        this.studentGradeService = studentGradeService;
    }

    @Override
    public Subject findById(Long id) {

        return null;
    }

    @Override
    public SubjectCommand save(SubjectCommand question) {
        Subject sub = commandToSubject.convert(question);
        Optional<Subject> schl = subjectRepo.findBySubjectNameAndTermAndSchoolGradeAndYearAndIsdeleted(sub.getSubjectName(), sub.getTerm(), sub.getSchoolGrade(), sub.getYear(), false);
        if (schl.isPresent()) {
            throw new RuntimeException("School Name Already Exists!");
        }

        return subjectToCommand.convert(subjectRepo.save(sub));
    }

    @Override
    public List<Subject> findAll() {
        return null;
    }

    @Override
    public SchoolGrade findById(SchoolGrade grade) {

       return null;

    }
}
