package com.projeto.lanchonete.enums.pedido;

public enum StatusPreparacao {
    PEDIDO_RECEBIDO(1),
    PEDIDO_EM_PREPARACAO(2),
    PEDIDO_PRONTO(3),
    PEDIDO_CANCELADO(4),
    PEDIDO_AGUARDANDO_ENTREGA(5),
    PEDIDO_A_CAMINHO(6),
    PEDIDO_ENTREGUE(7);

    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    private StatusPreparacao(int codigo){
        this.codigo = codigo;
    }

    public static StatusPreparacao valueOf(int codigo){
        for(StatusPreparacao value: StatusPreparacao.values()){
            if (codigo == value.getCodigo()){
                return value;
            }
        }
        throw  new IllegalArgumentException("Codigo invalido - StatusPreparacao");
    }

}
