package com.projeto.lanchonete.models;

import com.projeto.lanchonete.models.enums.pedido.FormaDeEntrega;
import com.projeto.lanchonete.models.enums.pedido.StatusPagamento;
import com.projeto.lanchonete.models.enums.pedido.StatusPreparacao;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_pedido")
public class PedidoModel {

    //Enums
    @Column(name = "forma_entrega")
    private Integer formaDeEntrega;

    @Column(name = "forma_pagamento")
    private Integer statusPagamento;

    @Column(name = "status_pedido")
    private Integer statusPreparacao;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    public PedidoModel(StatusPreparacao statusPreparacao, StatusPagamento statusPagamento, FormaDeEntrega formaDeEntrega) {
        setStatusPreparacao(statusPreparacao);
        setStatusPagamento(statusPagamento);
        setFormaDeEntrega(formaDeEntrega);
    }

    //FormaDeEntrega
    public FormaDeEntrega getFormaDeEntrega(){
        return FormaDeEntrega.valueOf(formaDeEntrega);
    }

    public void setFormaDeEntrega(FormaDeEntrega formaDeEntrega){
        if(formaDeEntrega != null){
            this.formaDeEntrega = formaDeEntrega.getCodigo();
        }
    }

    //StatusPagamento
    public StatusPagamento getStatusPagamento(){
        return StatusPagamento.valueOf(formaDeEntrega);
    }

    public void setStatusPagamento(StatusPagamento statusPagamento){
        if(statusPagamento != null){
            this.statusPagamento = statusPagamento.getCodigo();
        }
    }

    //StatusPreparacao
    public StatusPreparacao getStatusPreparacao(){
        return StatusPreparacao.valueOf(statusPreparacao);
    }

    public void setStatusPreparacao(StatusPreparacao statusPreparacao){
        if(statusPreparacao != null){
            this.statusPreparacao =  statusPreparacao.getCodigo();
        }
    }
}
