package got.cbtproject.gotcbt.repositories;

import got.cbtproject.gotcbt.model.SchoolClass;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long> {
    Optional<SchoolClass> findByClassType(String schoolClass);
    List<SchoolClass> findByIsdeleted(boolean isdeleted, Pageable pageable);
    List<SchoolClass> findByIsdeleted(boolean isdeleted);

}