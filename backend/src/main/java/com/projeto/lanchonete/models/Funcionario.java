package com.projeto.lanchonete.models;

import com.projeto.lanchonete.models.enums.funcionario.CargoFuncionario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Funcionario {


    private Integer cargoFuncionario;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "senha_funcionario")
    private String funcionarioLogin;

    @Column(name = "login_funcionario")
    private String funcionarioSenha;

    public Funcionario(CargoFuncionario cargoFuncionario, UUID id, String funcionarioLogin, String funcionarioSenha) {
        this.id = id;
        this.funcionarioLogin = funcionarioLogin;
        this.funcionarioSenha = funcionarioSenha;
        setCargoFuncionario(cargoFuncionario);
    }

    public CargoFuncionario getCargoFuncionario() {
        return CargoFuncionario.valueOf(cargoFuncionario);
    }

    public void setCargoFuncionario(CargoFuncionario cargoFuncionario) {
        if(cargoFuncionario != null){
            this.cargoFuncionario = cargoFuncionario.getCodigo();
        }
    }
}
