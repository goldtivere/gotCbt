package got.cbtproject.gotcbt.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends Person {
    private String studentClass;
    private String term;
    private String year;
}
