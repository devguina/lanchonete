package com.projeto.lanchonete.repositories;

import com.projeto.lanchonete.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository <Funcionario, UUID> {
}
