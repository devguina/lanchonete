package com.projeto.lanchonete.controllers;

import com.projeto.lanchonete.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;
}
