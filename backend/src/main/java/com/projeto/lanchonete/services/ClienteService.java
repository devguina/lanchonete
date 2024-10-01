package com.projeto.lanchonete.services;

import com.projeto.lanchonete.RecordsDto.ClienteRecordDto;
import com.projeto.lanchonete.models.ClienteModel;
import com.projeto.lanchonete.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    private ClienteRecordDto clienteRecordDto;

    // cadastrando clientes
    public ClienteModel createCliente(ClienteRecordDto clienteRecordDto){
        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteRecordDto, clienteModel);
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
    public ClienteModel updateCliente(UUID id, ClienteRecordDto clienteRecordDto){
        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteRecordDto, clienteModel);
        Optional<ClienteModel> clienteModelOptional = clienteRepository.findById(id);
        if(clienteModelOptional.isPresent()){
            clienteModel.setNomeCliente(clienteModel.getNomeCliente());
            clienteModel.setRuaCliente(clienteModel.getRuaCliente());
            clienteModel.setBairroCliente(clienteModel.getBairroCliente());
            clienteModel.setCidadeCliente(clienteModel.getCidadeCliente());
            clienteModel.setNumeroCasaCliente(clienteModel.getNumeroCasaCliente());
            clienteModel.setNumeroTelefoneCliente(clienteModel.getNumeroTelefoneCliente());
            clienteModel.setEmailCliente(clienteModel.getEmailCliente());

            return  clienteRepository.save(clienteModel);
        }
        else{
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }
    }
}
