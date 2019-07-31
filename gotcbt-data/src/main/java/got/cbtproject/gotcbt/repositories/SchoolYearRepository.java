package got.cbtproject.gotcbt.repositories;

import got.cbtproject.gotcbt.model.SchoolYear;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SchoolYearRepository extends CrudRepository<SchoolYear, Long> {

    Optional<SchoolYear> findByIdAndIsdeleted(Long Syear, boolean isdeleted);
}
