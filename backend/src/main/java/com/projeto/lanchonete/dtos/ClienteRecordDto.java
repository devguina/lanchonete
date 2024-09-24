package com.projeto.lanchonete.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ClienteRecordDto(@NotBlank @Size(max = 100) String nomeCliente,
                               @NotBlank @Size(max = 100) String ruaCliente,
                               @NotBlank @Size(max = 100) String bairroCliente,
                               @NotBlank @Size(max = 100) String cidadeCliente,
                               @NotNull int numeroCasaCliente,
                               @NotBlank @Size(max = 100) String numeroTelefoneCliente,
                               @NotBlank @Size(max = 100) String emailCliente) {
}
