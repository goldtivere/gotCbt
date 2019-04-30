package got.cbtproject.gotcbt.command;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class StudentClassCommand {
    public StudentClassCommand() {
    }

    private Long id;
    private String classType;
    private Long createdBy;
    private LocalDate dateCreated;
}
