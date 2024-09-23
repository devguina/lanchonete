package com.projeto.lanchonete.repositories;

import com.projeto.lanchonete.models.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LancheRepository extends JpaRepository<Lanche, UUID> {
}
