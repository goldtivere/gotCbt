package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbstudentdetails")
public class StudentClassDetails extends BaseEntity{

    @OneToMany
    @Column(name = "student_id")
    private List<Student> student;

    @Column(name = "school_grade")
    @OneToMany
    private List<SchoolGrade> schoolGrade= new ArrayList();
    @Column(name = "school_term")
    @OneToMany
    private List<SchoolTerm> schoolTerm= new ArrayList();
    @Column(name = "school_year")
    @OneToMany
    private List<SchoolYear> schoolYear= new ArrayList();
    @Column(name = "is_active")
    private int active;

    @Column(name = "created_on")
    private LocalDate localDate;

    @Column(name = "updatedon")
    private LocalDate updatedon;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "updated_by")
    private int updatedBy;
}
