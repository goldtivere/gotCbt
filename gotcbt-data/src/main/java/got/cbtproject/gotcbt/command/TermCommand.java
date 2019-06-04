package got.cbtproject.gotcbt.command;

import got.cbtproject.gotcbt.model.SchoolGrade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TermCommand {
    private Long id;
    private List<SchoolGrade> schoolGrades= new ArrayList<>();
    private String schlDept;
    private String schoolGrade;
    private String term;
    private Long createdBy;
    private LocalDate dateCreated;
    private Long updatedBy;
    private LocalDate dateupdated;
    private  LocalDate dateDeleted;
    private Long deletedBy;
    private boolean isdeleted;
}
