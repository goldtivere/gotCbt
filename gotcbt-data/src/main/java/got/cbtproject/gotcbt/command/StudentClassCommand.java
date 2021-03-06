package got.cbtproject.gotcbt.command;

import got.cbtproject.gotcbt.model.SchoolClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class StudentClassCommand extends SchoolClass {
    private Long id;
    private String classType;
    private Long createdBy;
    private LocalDate dateCreated;
    private Long updatedBy;
    private LocalDate dateupdated;
    private  LocalDate dateDeleted;
    private Long deletedBy;
    private boolean isdeleted;
}
