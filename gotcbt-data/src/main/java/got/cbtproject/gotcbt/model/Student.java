package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbstudent")
public class Student extends Person{

    @Column(name = "student_reg")
    private String regNum;
    @Column(name = "created_on")
    private LocalDate localDate;
    @Column(name = "created_by")
    private int createdBy;

}
