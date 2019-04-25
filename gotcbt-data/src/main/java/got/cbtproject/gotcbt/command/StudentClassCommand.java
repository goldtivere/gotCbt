package got.cbtproject.gotcbt.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentClassCommand {
    public StudentClassCommand() {
    }

    private Long id;
    private String classType;
}
