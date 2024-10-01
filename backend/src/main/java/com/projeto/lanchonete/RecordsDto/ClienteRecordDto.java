package com.projeto.lanchonete.RecordsDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteRecordDto(@NotBlank @Size(max =255 ) String nomeCliente,
                               @NotBlank @Size(max = 255) String ruaCliente,
                               @NotBlank @Size(max = 100) String bairroCliente,
                               @NotNull int numeroCasaCliente,
                               @NotBlank @Size(max = 20 ) String numeroTelefoneCliente,
                               @NotBlank @Size(max = 100) String emailCliente) {
}
