package got.cbtproject.gotcbt.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    private String subject;
    private String classSubject;
    private String term;
    private String year;
}
