package got.cbtproject.gotcbt.command;

import got.cbtproject.gotcbt.model.SchoolGrade;
import got.cbtproject.gotcbt.model.SchoolTerm;
import got.cbtproject.gotcbt.model.SchoolYear;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SubjectCommand {

    private String subjectName;
    private String schoolGrade;
    private String schoolTerm;
    private String subjectYear;
    private String dept;
    private List<SchoolGrade> schoolGrade1;
    private String entryType;


    private List<SchoolTerm> term= new ArrayList<>();

    private List<SchoolYear> year= new ArrayList<>();
    private Long createdBy;
    private LocalDate dateCreated;
    private Long updatedBy;
    private LocalDate dateupdated;
    private  LocalDate dateDeleted;
    private Long deletedBy;
    private boolean isdeleted;
}
