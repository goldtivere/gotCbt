package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person{

    private String regNum;
    private SchoolGrade schoolGrade;
    private SchoolTerm schoolTerm;
    private SchoolYear schoolYear;
}
