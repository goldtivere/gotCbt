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
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbstaff")
public class Instructor extends Person {

    @Column(name = "phone_number")
    private String phone_number;

    @OneToMany
    @Column(name = "staff_id")
    private List<Staff> staff;

    @Column(name = "created_on")
    private LocalDate localDate;

    @Column(name = "updatedon")
    private LocalDate updatedon;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "updated_by")
    private int updatedBy;

}
