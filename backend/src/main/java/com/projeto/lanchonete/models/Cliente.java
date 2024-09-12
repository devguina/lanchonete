package com.projeto.lanchonete.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "nome", unique = true)
    private String nomeCliente;

    @Column(name = "rua")
    private String ruaCliente;

    @Column(name = "bairro")
    private String bairroCliente;

    @Column(name = "cidade")
    private String cidadeCliente;

    @Column(name ="numero_casa" )
    private int numeroCasaCliente;

    @Column(unique = true, name = "telefone")
    private String numeroTelefoneCliente;

    @Column(unique = true, name = "email")
    private String emailCliente;
}
