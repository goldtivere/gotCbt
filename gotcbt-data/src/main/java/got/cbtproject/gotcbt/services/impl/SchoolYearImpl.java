package got.cbtproject.gotcbt.services.impl;

import got.cbtproject.gotcbt.model.SchoolYear;
import got.cbtproject.gotcbt.repositories.SchoolYearRepository;
import got.cbtproject.gotcbt.services.SchoolYearService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SchoolYearImpl implements SchoolYearService {

    private final SchoolYearRepository schoolYearRepository;

    public SchoolYearImpl(SchoolYearRepository schoolYearRepository) {
        this.schoolYearRepository = schoolYearRepository;
    }

    @Override
    public SchoolYear findByYear(Long sYear) {
        Optional<SchoolYear> schl = schoolYearRepository.findByIdAndIsdeleted(sYear,false);

        if (!schl.isPresent()) {
            throw new RuntimeException("Year Doesnt exist!");
        }
        return schl.get();
    }
}
