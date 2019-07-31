package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.SubjectCommand;
import got.cbtproject.gotcbt.model.Subject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommandToSubject implements Converter<SubjectCommand, Subject> {
    @Override
    public Subject convert(SubjectCommand source) {
        if(source == null)
        {
            return null;
        }
        final Subject sub= new Subject();
        sub.setSubjectName(source.getSubjectName());
        sub.setYear(source.getYear());
        sub.setTerm(source.getTerm());
        sub.setSchoolGrade(source.getSchoolGrade1());
        sub.setUpdatedBy(source.getUpdatedBy());
        sub.setDateupdated(source.getDateupdated());
        sub.setCreatedBy(source.getCreatedBy());
        sub.setDatecreated(source.getDateCreated());
        sub.setDateDeleted(source.getDateDeleted());
        sub.setDeletedBy(source.getDeletedBy());
        sub.setIsdeleted(source.isIsdeleted());

        return sub;
    }
}
