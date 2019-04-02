package got.cbtproject.gotcbt.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;
    private String correctAnswer;
    private Question question;
}
