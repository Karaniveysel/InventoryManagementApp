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
@Table(name = "CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;
    @Column(name="definition")
    String definition;


}