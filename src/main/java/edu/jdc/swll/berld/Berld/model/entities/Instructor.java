package edu.jdc.swll.berld.Berld.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {

    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String lastname;

    @ManyToMany(mappedBy = "instructorSet")
    private Set<Client> clientSet;
}
