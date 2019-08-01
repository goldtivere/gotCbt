package got.cbtproject.gotcbt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @Column(name = "school_class")
    private Long schoolGrade;

    @JsonIgnore
    @Column(name = "term")
    private Long term;

    @JsonIgnore
    @Column(name = "year")
    private Long year;
}
