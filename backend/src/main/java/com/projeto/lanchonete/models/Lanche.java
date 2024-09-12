package com.projeto.lanchonete.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Lanche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome_lanche")
    private String lancheNome;

    @Column(name = "ingredientes_lanche")
    private String lancheIngredientes;

    @Column(name = "valor_lanche")
    private float lancheValor;
}
