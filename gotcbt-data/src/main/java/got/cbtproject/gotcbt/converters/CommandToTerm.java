package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.TermCommand;
import got.cbtproject.gotcbt.model.SchoolTerm;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CommandToTerm implements Converter<TermCommand, SchoolTerm> {

    @Synchronized
    @Nullable
    @Override
    public SchoolTerm convert(TermCommand source) {
        if(source == null)
        {
            return null;
        }
        final SchoolTerm schoolGrade= new SchoolTerm();
        schoolGrade.setId(source.getId());
        schoolGrade.setSchoolGrades(source.getSchoolGrades());
        schoolGrade.setTerm(source.getTerm());
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
