package com.projeto.lanchonete.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClienteRecordDto(@NotBlank String nome,
                               @NotBlank String rua,
                               @NotBlank String bairro,
                               @NotBlank String cidade,
                               @NotNull int numeroCasa,
                               @NotBlank String numeroTelefone) {
}
