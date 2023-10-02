package com.example.spring1.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoyer")
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;
    @OneToOne
     Universite universite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
     Set<Bloc> blocs;

}
