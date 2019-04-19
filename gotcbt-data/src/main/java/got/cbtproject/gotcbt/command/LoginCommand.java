package got.cbtproject.gotcbt.command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginCommand {

    private String userId;
    private String password;
    private String role;
    private String permission;
    private int active;
}
