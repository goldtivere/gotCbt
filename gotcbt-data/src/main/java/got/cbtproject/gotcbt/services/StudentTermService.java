package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.command.TermCommand;
import got.cbtproject.gotcbt.model.SchoolTerm;

public interface StudentTermService {
    TermCommand save(TermCommand termCommand);
    SchoolTerm findById(Long id);
}
