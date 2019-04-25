package got.cbtproject.gotcbt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}
