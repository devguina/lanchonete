package com.projeto.lanchonete.dtos;

import jakarta.validation.constraints.NotBlank;

public record LancheRecordDto(@NotBlank String lancheNome,
                              @NotBlank String lancheIngredientes,
                              @NotBlank String lancheValor) {
}
