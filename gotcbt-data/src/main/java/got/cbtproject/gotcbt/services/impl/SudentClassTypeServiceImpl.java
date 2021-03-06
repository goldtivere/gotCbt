package got.cbtproject.gotcbt.services.impl;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.converters.CommandToStudentType;
import got.cbtproject.gotcbt.converters.StudentClassTypeCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.repositories.SchoolClassRepository;
import got.cbtproject.gotcbt.services.StudentClassTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SudentClassTypeServiceImpl implements StudentClassTypeService {
    private final SchoolClassRepository schoolClassRepository;
    private final CommandToStudentType commandToStudentType;
    private final StudentClassTypeCommand studentClassTypeCommand;

    public SudentClassTypeServiceImpl(SchoolClassRepository schoolClassRepository, CommandToStudentType commandToStudentType, StudentClassTypeCommand studentClassTypeCommand) {
        this.schoolClassRepository = schoolClassRepository;
        this.commandToStudentType = commandToStudentType;
        this.studentClassTypeCommand = studentClassTypeCommand;
    }

    @Override
    public StudentClassCommand save(StudentClassCommand schoolClass) {
        SchoolClass schoolClass1 = commandToStudentType.convert(schoolClass);
        System.out.println();
        Optional<SchoolClass> schl = schoolClassRepository.findByClassTypeAndIsdeleted(schoolClass1.getClassType(),false);

        if (schl.isPresent()) {
            throw new RuntimeException("School Group Already Exists!");
        }
        SchoolClass schoolSaved = schoolClassRepository.save(schoolClass1);
        return studentClassTypeCommand.convert(schoolSaved);
    }

    @Override
    public StudentClassCommand delete(StudentClassCommand schoolClass) {
        SchoolClass schoolClass1 = commandToStudentType.convert(schoolClass);
        Optional<SchoolClass> schl = schoolClassRepository.findByIdAndIsdeleted(schoolClass1.getId(),false);

        SchoolClass schoolSaved = schoolClassRepository.save(schoolClass1);
        return studentClassTypeCommand.convert(schoolSaved);
    }

//
//    @Override
//    public List<SchoolClass> findByCreatedBy(Long createdBy, PageRequest pageRequest) {
//        return schoolClassRepository.findByCreatedBy(createdBy,  pageRequest);
//    }

    @Override
    public SchoolClass findById(Long id) {
        Optional<SchoolClass> schl = schoolClassRepository.findByIdAndIsdeleted(id,false);

        if (!schl.isPresent()) {
            throw new RuntimeException("Id doesnt exist!");
        }

        return schl.get();
    }

    @Override
    public SchoolClass findByClassType(Long classType) {
        Optional<SchoolClass> schl = schoolClassRepository.findByIdAndIsdeleted(classType,false);
        if (!schl.isPresent()) {
            throw new RuntimeException("ClassType doesnt exist!");
        }
        return schl.get();
    }

    @Override
    public SchoolClass findByClassTypes(Long classType) {
        Optional<SchoolClass> schl = schoolClassRepository.findByIdAndIsdeleted(classType,false);
        if (!schl.isPresent()) {
            throw new RuntimeException("ClassType doesnt exist!");
        }
        return schl.get();
    }
}
