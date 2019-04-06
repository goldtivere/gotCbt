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
@Table(name = "tbschoolgrade")
public class SchoolGrade extends BaseEntity {

    @OneToMany
    @Column(name = "school_grade")
    private SchoolClass schoolClass;
    @Column(name = "school_class")
    private String grade;
}
