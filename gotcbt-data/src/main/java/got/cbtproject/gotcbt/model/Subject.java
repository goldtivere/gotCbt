package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbsubject")
public class Subject extends BaseEntity {
    @Column(name = "subject_name")
    private String subjectName;


    @Column(name = "school_class")
    private Long schoolGrade;


    @Column(name = "term")
    private Long term;


    @Column(name = "year")
    private Long year ;
}
