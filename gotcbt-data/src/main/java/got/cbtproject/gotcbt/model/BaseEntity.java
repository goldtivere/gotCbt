package got.cbtproject.gotcbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "createdBy")
    private Long createdBy;

    @Column(name = "datecreated")
    private LocalDate datecreated;

    @Column(name = "updatedBy")
    private Long updatedBy;

    @Column(name = "dateupdated")
    private LocalDate dateupdated;

    @Column(name="deletedBy")
    private Long deletedBy;

    @Column(name="dateDeleted")
    private LocalDate dateDeleted;

    @Column(name = "isdeleted")
    private boolean isdeleted;
}
