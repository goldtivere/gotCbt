package got.cbtproject.gotcbt.command;

import got.cbtproject.gotcbt.model.SchoolClass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class StudentGradeCommand {
    private Long id;
    private List<SchoolClass> schoolClass= new ArrayList<>();
    private String classGrade;
    private String grade;
    private Long createdBy;
    private LocalDate dateCreated;
    private Long updatedBy;
    private LocalDate dateupdated;
    private  LocalDate dateDeleted;
    private Long deletedBy;
    private boolean isdeleted;
}
