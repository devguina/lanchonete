package com.projeto.lanchonete.controllers;

import com.projeto.lanchonete.dtos.ClienteRecordDto;
import com.projeto.lanchonete.models.ClienteModel;
import com.projeto.lanchonete.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/cliente")
    public ResponseEntity<ClienteModel> postSalvaCliente(@RequestBody @Valid ClienteRecordDto clienteRecordDto){
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteRecordDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteModel>> getRetornaTodosClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }
}
