package got.cbtproject.gotcbt.model;

import got.cbtproject.gotcbt.enums.RolePermission;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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
    private Set<Role> role= new HashSet<>();

    @ElementCollection(fetch= FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="tbrole_permissions", joinColumns=@JoinColumn(name="userid"))
    private Set<RolePermission> permissions = new HashSet<>();

//    private String roles = "";
//
//    private String permissions = "";
//    @Column(name = "dateCreated")
//    private LocalDate dateCreated;
//    @Column(name = "createdBy")
//    private Long createdBy;

    public Users()
    {

    }

    public Users(String userId, String password, int active, Set<Role> role, Set<RolePermission> permissions) {
        this.userId = userId;
        this.password = password;
        this.active = active;
        this.role = role;
        this.permissions = permissions;
    }

    //    public List<String> getRoleList(){
//        if(this.roles.length() > 0){
//            return Arrays.asList(this.roles.split(","));
//        }
//        return new ArrayList<>();
//    }
//
//    public List<String> getPermissionList(){
//        if(this.permissions.length() > 0){
//            return Arrays.asList(this.permissions.split(","));
//        }
//        return new ArrayList<>();
//    }
}
