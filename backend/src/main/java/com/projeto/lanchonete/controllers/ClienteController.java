package com.projeto.lanchonete.controllers;

import com.projeto.lanchonete.RecordsDto.ClienteRecordDto;
import com.projeto.lanchonete.models.ClienteModel;
import com.projeto.lanchonete.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api", produces = {"apllication/json"})
@Tag(name = "/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Realiza o Cadastro de Clientes", method = "POST")
    @PostMapping(value = "/cliente")
    ResponseEntity<ClienteModel> postCliente(@RequestBody @Valid ClienteRecordDto clienteRecordDto){
        ClienteModel newCliente = clienteService.createCliente(clienteRecordDto);
        return new ResponseEntity<>(newCliente, HttpStatus.OK);
    }

    //GET ALL
    @Operation(summary = "Realiza o retorno de todos os Clientes cadastrados na Base de Dados", method = "GET")
    @GetMapping(value = "/cliente/all")
    ResponseEntity<List<ClienteModel>> getAllClientes(){
       List<ClienteModel> allCliente = clienteService.getAllClientes();
        return new ResponseEntity<>(allCliente,HttpStatus.OK );
    }

    //GET ID
    @Operation(summary = "Realiza o retorno de 1 Cliente com base no Id passado", method = "GET")
    @GetMapping(value = "/cliente/{id}")
    public ResponseEntity<?> findClienteById(@PathVariable UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findClienteById(id);
        if(clienteModelOptional.isPresent()){
            return ResponseEntity.ok(clienteModelOptional.get());
        }
        else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Desculpe, cliente não encontrado");
        }
    }

    @Operation(summary = "Método responsável por atualizar as informações de um cliente, com base no ID que é recebido",
                method = "PUT")
    @PutMapping("/cliente/update/{id}")
    public ResponseEntity<ClienteModel> updateCliente(@PathVariable UUID id,
                                                      @RequestBody @Valid ClienteRecordDto clienteRecordDto){
        try {
            ClienteModel updateClienteModel = clienteService.updateCliente(id, clienteRecordDto);
            return new ResponseEntity<>(updateClienteModel, HttpStatus.OK);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @Operation(summary = "Deleta um cliente com base no Id passado")
    @DeleteMapping("/cliente/delete/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findClienteById(id);
        if (clienteModelOptional.isPresent()){
            clienteService.deleteClienteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não econtrado");
    }
}
