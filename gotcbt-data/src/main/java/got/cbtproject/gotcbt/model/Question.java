package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question  extends BaseEntity{
    private String subject;
    private String classSubject;
    private String term;
    private String year;
}
