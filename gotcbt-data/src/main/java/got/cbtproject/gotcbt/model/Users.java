package got.cbtproject.gotcbt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "tbuser")
public class Users extends BaseEntity {
    @Column(name = "userid")
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private int active;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "tbuser_role", joinColumns = @JoinColumn(name = "userid"))
    private Set<Role> role;
    @Column(name = "dateCreated")
    private LocalDate dateCreated;
    @Column(name = "createdBy")
    private int createdBy;

}
