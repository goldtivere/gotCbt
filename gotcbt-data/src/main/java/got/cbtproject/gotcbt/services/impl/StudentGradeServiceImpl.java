package got.cbtproject.gotcbt.services.impl;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.converters.CommandToStudentGrade;
import got.cbtproject.gotcbt.converters.StudentGradeToCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.repositories.SchoolGradeRepository;
import got.cbtproject.gotcbt.services.StudentGradeService;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Optional<SchoolGrade> schl = schoolGradeRepository.findByGradeAndIsdeleted(schoolGrade.getGrade(),false);

        if (schl.isPresent()) {
            throw new RuntimeException("School Group Already Exists!");
        }
        SchoolGrade schoolSaved=schoolGradeRepository.save(schoolGrade);
        return studentGradeToCommand.convert(schoolSaved);
    }

//    @Override
//    public SchoolGrade findBySchoolClassType(SchoolClass classType,Pageable pageable) {
//        Optional<SchoolGrade> schl = schoolGradeRepository.findByIsdeletedAndAndSchoolClass(false,classType, pageable);
//        if (!schl.isPresent()) {
//            throw new RuntimeException("ClassType doesnt exist!");
//        }
//
//        return schl.get();
//    }


    @Override
    public SchoolGrade findById(Long id) {
        Optional<SchoolGrade> schl = schoolGradeRepository.findByIdAndIsdeleted(id,false);

        if (!schl.isPresent()) {
            throw new RuntimeException("Id doesnt exist!");
        }

        return schl.get();
    }

    @Override
    public StudentGradeCommand delete(StudentGradeCommand studentGradeCommand) {
        SchoolGrade schoolClass1 = commandToStudentGrade.convert(studentGradeCommand);
       // Optional<SchoolGrade> schl = schoolGradeRepository.findByClassType(schoolClass1.getClassType());

        SchoolGrade schoolSaved = schoolGradeRepository.save(schoolClass1);
       return studentGradeToCommand.convert(schoolSaved);

    }

    @Override
    public SchoolGrade findByGradeName(Long name) {
        Optional<SchoolGrade> schl = schoolGradeRepository.findByIdAndIsdeleted(name,false);

        if (!schl.isPresent()) {
            throw new RuntimeException("Grade doesnt exist!");
        }
        return schl.get();
    }

    @Override
    public List<SchoolGrade> findBySchoolClassType(SchoolClass classType) {
        System.out.println(classType.getId()+ " plus "+ classType.getClassType());
        List<SchoolGrade> schl = schoolGradeRepository.findByIsdeletedAndSchoolClass(false,classType);
        if (!schl.isEmpty()) {
            throw new RuntimeException("ClassType doesnt exist!");
        }

        return schl;
    }
}
