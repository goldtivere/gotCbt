package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbschoolterm")
public class SchoolTerm extends BaseEntity{
    @Column(name = "term")
    private String term;
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "schoolTerm")
    @JoinTable(name="tbterm_class",joinColumns =@JoinColumn(name="school_term_id"), inverseJoinColumns = @JoinColumn(name="school_grade_id"))
    private List<SchoolGrade> schoolGrades= new ArrayList<>();
}
