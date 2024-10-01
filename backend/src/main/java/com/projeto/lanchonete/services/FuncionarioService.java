package com.projeto.lanchonete.services;

import com.projeto.lanchonete.RecordsDto.FuncionarioRecordDto;
import com.projeto.lanchonete.models.FuncionarioModel;
import com.projeto.lanchonete.repositories.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    private FuncionarioRecordDto funcionarioRecordDto;

    //criando funcionario
    public FuncionarioModel addFuncionario(FuncionarioRecordDto funcionarioRecordDto){
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioRecordDto, funcionarioModel);
        return funcionarioRepository.save(funcionarioModel);
    }

    // retornando todos funcionarios
    public List<FuncionarioModel> returAllFuncionario(){
       return funcionarioRepository.findAll();
    }

    // retornando um funcionario pelo id
    public Optional<FuncionarioModel> returFuncionario(UUID id){
        return funcionarioRepository.findById(id);
    }

    public void deleteFuncionario(UUID id){
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioModel updateFuncionario(UUID id, FuncionarioRecordDto funcionarioRecordDto){
        Optional<FuncionarioModel> funcionarioModelOptional = funcionarioRepository.findById(id);
        if(funcionarioModelOptional.isPresent()){
            FuncionarioModel funcionarioModel = new FuncionarioModel();
            BeanUtils.copyProperties(funcionarioRecordDto, funcionarioModel);

            funcionarioModel.setNomeFuncionario(funcionarioModel.getNomeFuncionario());
            funcionarioModel.setSobreNomeFuncionario(funcionarioModel.getSobreNomeFuncionario());
            funcionarioModel.setTelefoneFuncionario(funcionarioModel.getTelefoneFuncionario());
            funcionarioModel.setFuncionarioLogin(funcionarioModel.getFuncionarioLogin());
            funcionarioModel.setFuncionarioSenha(funcionarioModel.getFuncionarioSenha());
            funcionarioModel.setNomeFuncionario(funcionarioModel.getNomeFuncionario());
            return funcionarioRepository.save(funcionarioModel);
        }
        else {
            throw new RuntimeException("Funcionario com este ID não encontrado: "+id);
        }
    }
}
