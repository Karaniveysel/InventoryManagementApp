package com.example.services.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
@Audited
@EnableAutoConfiguration
@Entity
@Table(name = "DEPOT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Depot {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;
    @Column(name="definition")
    String definition;
    @Column(name="address")
    String address;
    @Column(name="region")
    String region;
    @Column(name="City")
    String City;



}
