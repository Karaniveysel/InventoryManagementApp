package com.example.services.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Set;
@Audited
@EnableAutoConfiguration
@Entity
@Table(name = "PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;
    @Column(name="definition")
    String definition;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
    @Column(name="threshold")
    String threshold;
    @Column(name="status")
    String status;


}
