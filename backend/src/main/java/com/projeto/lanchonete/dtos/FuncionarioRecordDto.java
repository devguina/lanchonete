package com.projeto.lanchonete.dtos;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioRecordDto(@NotBlank String loginFuncionario,
                                   @NotBlank String senhaFuncionario) {
}
