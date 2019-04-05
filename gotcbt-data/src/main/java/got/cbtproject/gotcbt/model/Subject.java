package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject  extends BaseEntity{
    private String subjectName;
    private SchoolGrade schoolGrade;
    private SchoolTerm term;
    private SchoolYear year;
}
