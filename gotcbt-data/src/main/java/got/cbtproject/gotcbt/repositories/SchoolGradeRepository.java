package got.cbtproject.gotcbt.repositories;

import got.cbtproject.gotcbt.model.SchoolClass;
import got.cbtproject.gotcbt.model.SchoolGrade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolGradeRepository extends CrudRepository<SchoolGrade, Long> {
    Optional<SchoolGrade> findByGradeAndIsdeleted(String SchoolGrade, boolean isdeleted);

    List<SchoolGrade> findByIsdeleted(boolean isdeleted, Pageable pageable);

    List<SchoolGrade> findByIsdeletedAndAndSchoolClass(boolean isdeleted, SchoolClass schoolClass, Pageable pageable);

    List<SchoolGrade> findByIsdeletedAndAndSchoolClass(boolean isdeleted, SchoolClass schoolClass);
}
