package com.projeto.lanchonete.controllers;

import com.projeto.lanchonete.dtos.FuncionarioRecordDto;
import com.projeto.lanchonete.models.FuncionarioModel;
import com.projeto.lanchonete.repositories.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @PostMapping("/funcionario")
    ResponseEntity<FuncionarioModel> salvaFuncionario (@RequestBody @Valid FuncionarioRecordDto funcionarioRecordDto){
        var funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioRecordDto, funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionarioModel));
    }
}
