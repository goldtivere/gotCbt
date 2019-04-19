package got.cbtproject.gotcbt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "tbuser_role", joinColumns = @JoinColumn(name = "userid"))
//    private Set<Role> role= new HashSet<>();
//
//    @ElementCollection(fetch= FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name="role_permissions", joinColumns=@JoinColumn(name="userid"))
//    private Set<RolePermission> permissions = new HashSet<>();

    private String roles = "";

    private String permissions = "";
    @Column(name = "dateCreated")
    private LocalDate dateCreated;
    @Column(name = "createdBy")
    private int createdBy;

    public Users()
    {

    }
    public Users(String userId, String password, int active, String roles, String permissions, LocalDate dateCreated, int createdBy) {
        this.userId = userId;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.permissions = permissions;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
