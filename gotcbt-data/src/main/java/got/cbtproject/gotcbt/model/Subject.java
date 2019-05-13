package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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
    private List<SchoolGrade> schoolGrade;
    @OneToMany
    @Column(name = "term")
    private List<SchoolTerm> term= new ArrayList<>();
    @OneToMany
    @Column(name = "year")
    private List<SchoolYear> year= new ArrayList<>();
}
