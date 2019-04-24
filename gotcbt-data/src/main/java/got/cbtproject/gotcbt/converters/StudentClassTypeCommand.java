package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.StudentClassCommand;
import got.cbtproject.gotcbt.model.SchoolClass;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentClassTypeCommand implements Converter<SchoolClass, StudentClassCommand> {

    @Override
    public StudentClassCommand convert(SchoolClass source) {
        if(source == null) {
            return null;
        }
        final StudentClassCommand studentClassCommand= new StudentClassCommand();
        studentClassCommand.setId(source.getId());
        studentClassCommand.setClassType(source.getClassType());

        return studentClassCommand;
    }
}
