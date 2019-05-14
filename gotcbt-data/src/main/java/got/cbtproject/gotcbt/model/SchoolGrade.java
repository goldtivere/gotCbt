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
@Table(name = "tbschoolgrade")
public class SchoolGrade extends BaseEntity {

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "schoolDeparment")
    @JoinTable(name="tbgrade_class",joinColumns =@JoinColumn(name="school_Grade_id"), inverseJoinColumns = @JoinColumn(name="school_class_id"))
    private List<SchoolClass> schoolClass= new ArrayList<>();
    @Column(name = "school_class")
    private String grade;

}
