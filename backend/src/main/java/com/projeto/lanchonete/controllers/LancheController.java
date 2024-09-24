package com.projeto.lanchonete.controllers;

import com.projeto.lanchonete.dtos.LancheRecordDto;
import com.projeto.lanchonete.models.LancheModel;
import com.projeto.lanchonete.repositories.LancheRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LancheController {

    @Autowired
    LancheRepository lancheRepository;

    @PostMapping
    ResponseEntity<LancheModel> salvaLanche(@RequestBody @Valid LancheRecordDto lancheRecordDto){
        var lancheModel = new LancheModel();
        BeanUtils.copyProperties(lancheRecordDto, lancheModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancheRepository.save(lancheModel));
    }
}
