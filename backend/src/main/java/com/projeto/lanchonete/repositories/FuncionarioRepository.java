package com.projeto.lanchonete.repositories;

import com.projeto.lanchonete.models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository <FuncionarioModel, UUID> {
}
