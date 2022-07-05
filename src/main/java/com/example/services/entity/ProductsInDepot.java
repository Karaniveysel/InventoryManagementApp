package com.example.services.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Audited
@EnableAutoConfiguration
@Entity
@Table(name = "PRODUCTSINDEPOT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsInDepot {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;
    @ManyToOne
    @JoinColumn(name = "depot_id")
    Depot depot;
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
    @Column(name="quantity")
    long quantity;








}