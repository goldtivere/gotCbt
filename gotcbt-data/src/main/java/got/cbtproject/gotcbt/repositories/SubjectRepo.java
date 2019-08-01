package got.cbtproject.gotcbt.repositories;

import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.model.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepo extends CrudRepository<Subject, Long> {
    Optional<Subject> findBySubjectNameAndTermAndSchoolGradeAndYearAndIsdeleted(String sub, Long schoolTerm,
                                                                             Long schoolGrade, Long schoolYear, boolean isdeleted);
    List<Subject> findByTermAndSchoolGradeAndYearAndIsdeleted(Long schoolTerm,
                                                                            Long schoolGrade, Long schoolYear, boolean isdeleted);
    Subject findBySchoolGradeAndIsdeleted(SchoolGrade grade,boolean isdeleted);
}
