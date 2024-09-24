package com.projeto.lanchonete.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_lanche")
public class LancheModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome_lanche",nullable = false)
    private String lancheNome;

    @Column(name = "ingredientes_lanche",nullable = false)
    private String lancheIngredientes;

    @Column(name = "valor_lanche", nullable = false)
    private float lancheValor;
}
