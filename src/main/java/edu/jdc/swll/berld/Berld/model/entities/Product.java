package edu.jdc.swll.berld.Berld.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long serial;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

}
