package edu.jdc.swll.berld.Berld.model.entities;

import edu.jdc.swll.berld.Berld.model.enums.RhType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.Instant;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Client extends User{

    @Column
    private Long document;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private Instant birthDate;
    @Column
    private RhType rh;
    @Column
    private Instant startDate;
    @Column
    private String phone;

    @ManyToOne
    @JoinColumn(name = "workplan_id")
    private WorkPlan workplan;

    @ManyToMany
    @JoinTable(
            name = "\"client_has_instructor\"",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private Set<Instructor> instructorSet;
}
