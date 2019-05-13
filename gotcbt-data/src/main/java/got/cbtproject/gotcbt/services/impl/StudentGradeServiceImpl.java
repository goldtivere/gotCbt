package got.cbtproject.gotcbt.services.impl;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.converters.CommandToStudentGrade;
import got.cbtproject.gotcbt.converters.StudentGradeToCommand;
import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.repositories.SchoolGradeRepository;
import got.cbtproject.gotcbt.services.StudentGradeService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentGradeServiceImpl implements StudentGradeService {
    private final SchoolGradeRepository schoolGradeRepository;
    private final StudentGradeToCommand studentGradeToCommand;
    private final CommandToStudentGrade commandToStudentGrade;

    public StudentGradeServiceImpl(SchoolGradeRepository schoolGradeRepository, StudentGradeToCommand studentGradeToCommand, CommandToStudentGrade commandToStudentGrade) {
        this.schoolGradeRepository = schoolGradeRepository;
        this.studentGradeToCommand = studentGradeToCommand;
        this.commandToStudentGrade = commandToStudentGrade;
    }

    @Override
    public StudentGradeCommand save(StudentGradeCommand studentGradeCommand) {
        SchoolGrade schoolGrade= commandToStudentGrade.convert(studentGradeCommand);
        Optional<SchoolGrade> schl = schoolGradeRepository.findByGrade(schoolGrade.getGrade());

        if (schl.isPresent()) {
            throw new RuntimeException("School Group Already Exists!");
        }
        SchoolGrade schoolSaved=schoolGradeRepository.save(schoolGrade);
        return studentGradeToCommand.convert(schoolSaved);
    }
}
