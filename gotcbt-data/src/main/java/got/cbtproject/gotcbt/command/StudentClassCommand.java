package got.cbtproject.gotcbt.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StudentClassCommand {
    private Long id;
    private String classType;
}
