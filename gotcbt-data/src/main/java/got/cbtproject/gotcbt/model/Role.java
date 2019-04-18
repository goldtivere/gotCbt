package got.cbtproject.gotcbt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name="role")
public class Role extends BaseEntity{

    @Column(name = "role")
    private String role;

    public Role()
    {

    }

    public Role(String role) {
        this.role = role;
    }
}
