package got.cbtproject.gotcbt.repositories;

import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.model.SchoolTerm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SchoolTermRepository extends CrudRepository<SchoolTerm, Long> {
    List<SchoolTerm> findByIsdeletedAndSchoolGrades(boolean isdeleted, SchoolGrade schoolGrade);
}
