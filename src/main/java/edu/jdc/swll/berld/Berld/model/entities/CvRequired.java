package edu.jdc.swll.berld.Berld.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CvRequired {

    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long id;

    @Column
    private String description;
    @Column
    private Instant announcementDate;
    @Column
    private Boolean available;
    @Column
    private Integer vacancyNumber;

}
