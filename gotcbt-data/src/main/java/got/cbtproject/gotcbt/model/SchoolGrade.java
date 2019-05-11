package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbschoolgrade")
public class SchoolGrade extends BaseEntity {

    @OneToMany
    @Column(name = "schoolDeparment")
    private List<SchoolClass> schoolClass;
    @Column(name = "school_class")
    private String grade;
}
