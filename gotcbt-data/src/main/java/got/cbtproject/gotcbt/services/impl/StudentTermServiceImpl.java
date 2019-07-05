package got.cbtproject.gotcbt.services.impl;

import got.cbtproject.gotcbt.command.TermCommand;
import got.cbtproject.gotcbt.converters.CommandToTerm;
import got.cbtproject.gotcbt.converters.TermToCommand;
import got.cbtproject.gotcbt.model.SchoolTerm;
import got.cbtproject.gotcbt.repositories.SchoolTermRepository;
import got.cbtproject.gotcbt.services.StudentTermService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentTermServiceImpl implements StudentTermService {
    private final TermToCommand termToCommand;
    private final CommandToTerm commandToTerm;
    private final SchoolTermRepository schoolTermRepository;

    public StudentTermServiceImpl(TermToCommand termToCommand, CommandToTerm commandToTerm, SchoolTermRepository schoolTermRepository) {
        this.termToCommand = termToCommand;
        this.commandToTerm = commandToTerm;
        this.schoolTermRepository = schoolTermRepository;
    }

    @Override
    public TermCommand save(TermCommand termCommand) {
        SchoolTerm schoolTerm= commandToTerm.convert(termCommand);
        Optional<SchoolTerm> schl = schoolTermRepository.findByTermAndIsdeleted(schoolTerm.getTerm(),false);

        if (schl.isPresent()) {
            throw new RuntimeException("School Group Already Exists!");
        }
        SchoolTerm schoolTerm1=schoolTermRepository.save(schoolTerm);
        return termToCommand.convert(schoolTerm1);
    }

    @Override
    public SchoolTerm findById(Long id) {
        try {
            Optional<SchoolTerm> schl = schoolTermRepository.findByIdAndIsdeleted(id, false);

            if (!schl.isPresent()) {
                throw new RuntimeException("Id doesnt exist!");
            }

            return schl.get();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TermCommand delete(TermCommand schoolClass) {
        SchoolTerm schoolClass1 = commandToTerm.convert(schoolClass);
        // Optional<SchoolGrade> schl = schoolGradeRepository.findByClassType(schoolClass1.getClassType());

        SchoolTerm schoolSaved = schoolTermRepository.save(schoolClass1);
        return termToCommand.convert(schoolSaved);
    }
}
