package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.StudentGradeCommand;
import got.cbtproject.gotcbt.model.SchoolGrade;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component

public class CommandToStudentGrade implements Converter<StudentGradeCommand, SchoolGrade> {
    private final CommandToStudentType commandToStudentType;

    public CommandToStudentGrade(CommandToStudentType commandToStudentType) {
        this.commandToStudentType = commandToStudentType;
    }

    @Synchronized
    @Nullable
    @Override
    public SchoolGrade convert(StudentGradeCommand source) {
        if(source == null)
        {
            return null;
        }
        final SchoolGrade schoolGrade= new SchoolGrade();
        schoolGrade.setId(source.getId());
        schoolGrade.setGrade(source.getGrade());
        schoolGrade.setSchoolClass(source.getSchoolClass());
        schoolGrade.setUpdatedBy(source.getUpdatedBy());
        schoolGrade.setDateupdated(source.getDateupdated());
        schoolGrade.setCreatedBy(source.getCreatedBy());
        schoolGrade.setDatecreated(source.getDateCreated());
        schoolGrade.setDateDeleted(source.getDateDeleted());
        schoolGrade.setDeletedBy(source.getDeletedBy());
        schoolGrade.setIsdeleted(source.isIsdeleted());


        return schoolGrade;
    }
}
