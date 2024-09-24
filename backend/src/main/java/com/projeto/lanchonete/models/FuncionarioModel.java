package com.projeto.lanchonete.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "senha_funcionario", nullable = false)
    private String funcionarioLogin;

    @Column(name = "login_funcionario", nullable = false)
    private String funcionarioSenha;

    public FuncionarioModel() {
        this.funcionarioLogin = funcionarioLogin;
        this.funcionarioSenha = funcionarioSenha;
    }
}

