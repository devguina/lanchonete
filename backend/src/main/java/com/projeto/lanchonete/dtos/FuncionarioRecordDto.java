package com.projeto.lanchonete.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FuncionarioRecordDto(@NotBlank @Size(min = 5, max = 20) String loginFuncionario,
                                   @NotBlank @Size(min = 12, max = 20) String senhaFuncionario) {
}
