package com.projeto.lanchonete.services;

import com.projeto.lanchonete.models.ClienteModel;
import com.projeto.lanchonete.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // cadastrando clientes
    public ClienteModel createCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    // mostrando todos clientes
    public List<ClienteModel> getAllClientes(){
        return clienteRepository.findAll();
    }

    // mostra um cliente buscando pelo ID
    public Optional<ClienteModel> findClienteById(UUID id){
        return clienteRepository.findById(id);
    }

    //deleta cliente por id
    public void deleteClienteById(UUID id){
        clienteRepository.deleteById(id);
    }

    //atualiza cliente
    public ClienteModel updateCliente(UUID id, ClienteModel newclienteModel){
        Optional<ClienteModel> clienteModelOptional = clienteRepository.findById(id);
        if(clienteModelOptional.isPresent()){
            ClienteModel clienteModel = clienteModelOptional.get();
            clienteModel.setNomeCliente(newclienteModel.getNomeCliente());
            clienteModel.setRuaCliente(newclienteModel.getRuaCliente());
            clienteModel.setBairroCliente(newclienteModel.getBairroCliente());
            clienteModel.setCidadeCliente(newclienteModel.getCidadeCliente());
            clienteModel.setNumeroCasaCliente(newclienteModel.getNumeroCasaCliente());
            clienteModel.setNumeroTelefoneCliente(newclienteModel.getNumeroTelefoneCliente());
            clienteModel.setEmailCliente(newclienteModel.getEmailCliente());

            return  clienteRepository.save(clienteModel);
        }
        else{
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }
    }
}
