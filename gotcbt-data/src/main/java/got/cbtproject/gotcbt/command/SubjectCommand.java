package got.cbtproject.gotcbt.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SubjectCommand {

    private String subjectName;
    private String schoolGrade;
    private String schoolTerm;
    private String subjectYear;
    private String dept;
    private Long schoolGrade1;
    private String entryType;


    private Long term;

    private Long year;
    private Long createdBy;
    private LocalDate dateCreated;
    private Long updatedBy;
    private LocalDate dateupdated;
    private  LocalDate dateDeleted;
    private Long deletedBy;
    private boolean isdeleted;
}
