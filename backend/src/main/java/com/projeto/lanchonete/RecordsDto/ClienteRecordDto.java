package com.projeto.lanchonete.RecordsDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteRecordDto(@NotBlank @Size(max =255 ) String nomeCliente,
                               @NotBlank @Size(max = 255) String ruaCliente,
                               @NotBlank @Size(max = 100) String bairroCliente,
                               @NotBlank @Size(max = 100) String cidadeCliente,
                               @NotNull int numeroCasaCliente,
                               @NotBlank @Size(max = 20 ) String numeroTelefoneCliente,
                               @NotBlank @Valid @Email @Size(max = 100) String emailCliente) {
}
