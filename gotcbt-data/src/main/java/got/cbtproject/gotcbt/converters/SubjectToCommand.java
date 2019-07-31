package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.SubjectCommand;
import got.cbtproject.gotcbt.model.Subject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubjectToCommand implements Converter<Subject, SubjectCommand> {

    @Override
    public SubjectCommand convert(Subject source) {
        if(source == null)
        {
            return null;
        }
        final SubjectCommand sub= new SubjectCommand();
        sub.setSubjectName(source.getSubjectName());
        sub.setYear(source.getYear());
        sub.setTerm(source.getTerm());
        sub.setSchoolGrade1(source.getSchoolGrade());
        sub.setUpdatedBy(source.getUpdatedBy());
        sub.setDateupdated(source.getDateupdated());
        sub.setCreatedBy(source.getCreatedBy());
        sub.setDateCreated(source.getDatecreated());
        sub.setDateDeleted(source.getDateDeleted());
        sub.setDeletedBy(source.getDeletedBy());
        sub.setIsdeleted(source.isIsdeleted());

        return sub;
    }

}
