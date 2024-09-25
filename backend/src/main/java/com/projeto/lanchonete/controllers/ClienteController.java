package com.projeto.lanchonete.controllers;

import com.projeto.lanchonete.models.ClienteModel;
import com.projeto.lanchonete.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/cliente")
    public ResponseEntity<ClienteModel> postSalvaCliente(@RequestBody @Valid ClienteModel clienteModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteModel>> getRetornaTodosClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Optional<ClienteModel>> getUmCliente (@PathVariable (value = "id")UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findById(id));
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<ClienteModel> atualizaCliente(
            @PathVariable(value = "id") UUID id,
            @RequestBody  ClienteModel clienteModelDetalhes){
       Optional<ClienteModel> clienteModelOptional = clienteRepository.findById(id);
        var atualizaClienteModel = clienteModelOptional.get();
        atualizaClienteModel.setNomeCliente(clienteModelDetalhes.getNomeCliente());
        return ResponseEntity.status(HttpStatus.OK).body(atualizaClienteModel);

    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Object> deletaCliente(
            @PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteRepository.findById(id);
        clienteRepository.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido com sucesso!");
    }
}
