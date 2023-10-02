package com.example.spring1.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre ;
    long numeroChambre ;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;
}
