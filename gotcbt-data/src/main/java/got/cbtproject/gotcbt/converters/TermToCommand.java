package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.TermCommand;
import got.cbtproject.gotcbt.model.SchoolTerm;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TermToCommand implements Converter<SchoolTerm, TermCommand> {
    @Synchronized
    @Nullable
    @Override
    public TermCommand convert(SchoolTerm source) {
        if (source == null) {
            return null;
        }
        final TermCommand command = new TermCommand();

        command.setId(source.getId());
        command.setTerm(source.getTerm());
        command.setSchoolGrades(source.getSchoolGrades());
        command.setUpdatedBy(source.getUpdatedBy());
        command.setDateupdated(source.getDateupdated());
        command.setCreatedBy(source.getCreatedBy());
        command.setDateCreated(source.getDatecreated());
        command.setDateDeleted(source.getDateDeleted());
        command.setDeletedBy(source.getDeletedBy());
        command.setIsdeleted(source.isIsdeleted());

        return command;
    }
}
