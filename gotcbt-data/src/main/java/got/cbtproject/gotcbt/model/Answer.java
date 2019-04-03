package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;
    private String correctAnswer;
    private Question question;
}
