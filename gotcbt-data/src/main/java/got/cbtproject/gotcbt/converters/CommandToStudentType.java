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

        return schoolClass;
    }

}
