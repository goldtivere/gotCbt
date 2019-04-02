package got.cbtproject.gotcbt.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String firstName;
    private String middlename;
    private String lastName;
}
