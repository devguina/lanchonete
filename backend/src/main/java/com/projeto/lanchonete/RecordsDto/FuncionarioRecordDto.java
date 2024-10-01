package com.projeto.lanchonete.RecordsDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FuncionarioRecordDto(@NotBlank @Size(max = 30) String nomeFuncionario,
                                   @NotBlank @Size(max = 100) String sobreNomeFuncionario,
                                   @NotBlank @Size(max = 20) String telefoneFuncionario,
                                   @NotBlank @Size(max = 30) String funcionarioLogin,
                                   @NotBlank @Size(max = 30) String funcionarioSenha) {
}
