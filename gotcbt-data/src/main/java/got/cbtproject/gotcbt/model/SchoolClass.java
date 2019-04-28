package got.cbtproject.gotcbt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="tbschoolclass")
public class SchoolClass extends BaseEntity {

    public SchoolClass()
    {

    }
    @Column(name = "classType")
    private String classType;

    @Column(name = "createdBy")
    private int createdBy;

    @Column(name = "classType")
    private LocalDate datecreated;

    @Column(name = "updatedBy")
    private int updatedBy;

    @Column(name = "classType")
    private LocalDate dateupdated;


}
