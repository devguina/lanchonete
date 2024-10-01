package com.projeto.lanchonete.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name = "tb_funcionario")
public class FuncionarioModel {

    /*TODO
    corrigir o nome de alguns métodos e lembrar de mudar no controller records e service
    caso tenha usado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome_funcionario", nullable = false)
    private String nomeFuncionario;

    @Column(name = "sobrenome_funcionario", nullable = false)
    private String sobreNomeFuncionario;

    @Column(name = "telefone_cliente", nullable = false)
    private String telefoneFuncionario;


    @Column(name = "senha_funcionario", nullable = false)
    private String funcionarioLogin;

    @Column(name = "login_funcionario", nullable = false)
    private String funcionarioSenha;

    public FuncionarioModel(String funcionarioLogin, String funcionarioSenha) {
        this.funcionarioLogin = funcionarioLogin;
        this.funcionarioSenha = funcionarioSenha;
    }

    public FuncionarioModel(String funcionarioLogin, String funcionarioSenha, String nomeFuncionario,
                            String sobreNomeFuncionario, String telefoneFuncionario){
        this(funcionarioLogin,funcionarioSenha);
        this.nomeFuncionario = nomeFuncionario;
        this.sobreNomeFuncionario = sobreNomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
    }
}

