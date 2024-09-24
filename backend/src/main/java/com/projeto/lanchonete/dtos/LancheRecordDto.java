package com.projeto.lanchonete.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LancheRecordDto(@NotBlank @Size(max = 100) String lancheNome,
                              @NotBlank @Size(max = 400) String lancheIngredientes,
                              @NotNull float lancheValor) {
}
