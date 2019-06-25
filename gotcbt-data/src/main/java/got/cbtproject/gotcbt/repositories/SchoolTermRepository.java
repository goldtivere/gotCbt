package got.cbtproject.gotcbt.repositories;

import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.model.SchoolTerm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolTermRepository extends CrudRepository<SchoolTerm, Long> {
    List<SchoolTerm> findByIsdeletedAndSchoolGrades(boolean isdeleted, SchoolGrade schoolGrade);
    Optional<SchoolTerm> findByTermAndIsdeleted(String term, boolean isdeleted);
    Optional<SchoolTerm> findByIdAndIsdeleted(Long schoolTerm, boolean isdeleted);
}
