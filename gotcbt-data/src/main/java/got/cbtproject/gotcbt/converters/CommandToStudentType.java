package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommandToStudentType implements Converter<StudentClassCommand, SchoolClass> {
    @Synchronized
    @Override
    public SchoolClass convert(StudentClassCommand source) {
        if(source == null)
        {
            return null;
        }
        final SchoolClass schoolClass= new SchoolClass();
        schoolClass.setId(source.getId());
        schoolClass.setClassType(source.getClassType());
        schoolClass.setUpdatedBy(source.getUpdatedBy());
        schoolClass.setDateupdated(source.getDateupdated());
        schoolClass.setCreatedBy(source.getCreatedBy());
        schoolClass.setDatecreated(source.getDateCreated());
        schoolClass.setDateDeleted(source.getDateDeleted());
        schoolClass.setDeletedBy(source.getDeletedBy());
        schoolClass.setIsdeleted(source.isIsdeleted());

        return schoolClass;
    }

}
