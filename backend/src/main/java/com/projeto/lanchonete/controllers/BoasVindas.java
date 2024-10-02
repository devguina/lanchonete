package com.projeto.lanchonete.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoasVindas {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem vindo a minha API como um endingpoint publico";
    }

    @GetMapping("/restito")
    public String boasVindasRestrito(){
        return "Bem vindo a minha API com um endingpoint Restrito, provávelmente voce esta autenticado";
    }
}
