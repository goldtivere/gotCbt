package got.cbtproject.gotcbt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @Column(name = "createdBy")
    private Long createdBy;

    @JsonIgnore
    @Column(name = "datecreated")
    private LocalDate datecreated;
    @JsonIgnore
    @Column(name = "updatedBy")
    private Long updatedBy;
    @JsonIgnore
    @Column(name = "dateupdated")
    private LocalDate dateupdated;
    @JsonIgnore
    @Column(name = "deletedBy")
    private Long deletedBy;
    @JsonIgnore
    @Column(name = "dateDeleted")
    private LocalDate dateDeleted;
    @JsonIgnore
    @Column(name = "isdeleted")
    private boolean isdeleted;
}
