package com.projeto.lanchonete.repositories;

import com.projeto.lanchonete.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
}
