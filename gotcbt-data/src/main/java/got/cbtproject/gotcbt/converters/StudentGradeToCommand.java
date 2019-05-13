package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.model.SchoolGrade;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentGradeToCommand implements Converter<SchoolGrade, StudentGradeCommand> {

    private final StudentClassTypeCommand commandToStudentType;

    public StudentGradeToCommand(StudentClassTypeCommand commandToStudentType) {
        this.commandToStudentType = commandToStudentType;
    }

    @Synchronized
    @Nullable
    @Override
    public StudentGradeCommand convert(SchoolGrade source) {
        if(source == null)
        {
            return null;
        }
        final StudentGradeCommand command= new StudentGradeCommand();

        command.setId(source.getId());
        command.setGrade(source.getGrade());

        command.setUpdatedBy(source.getUpdatedBy());
        command.setDateupdated(source.getDateupdated());
        command.setCreatedBy(source.getCreatedBy());
        command.setDateCreated(source.getDatecreated());
        command.setDateDeleted(source.getDateDeleted());
        command.setDeletedBy(source.getDeletedBy());
        command.setIsdeleted(source.isIsdeleted());
        if (source.getSchoolClass() != null && source.getSchoolClass().size() > 0){
            source.getSchoolClass().forEach( schoolClass -> command.getSchoolClass().add(commandToStudentType.convert(schoolClass)));
        }
        return command;
    }
}
