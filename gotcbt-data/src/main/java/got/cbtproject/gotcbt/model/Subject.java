package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbsubject")
public class Subject  extends BaseEntity{
    @Column(name = "subject_name")
    private String subjectName;

    @OneToMany
    @Column(name = "school_class")
    private SchoolGrade schoolGrade;
    @OneToMany
    @Column(name = "term")
    private SchoolTerm term;
    @OneToMany
    @Column(name = "year")
    private SchoolYear year;
}
