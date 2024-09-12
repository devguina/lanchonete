package com.projeto.lanchonete.enums.pedido;

public enum StatusPagamento {
    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    PAGAMENTO_DINHEIRO(3),
    PAGAMENTO_CARTAO(4),
    PAGAMENTO_PIX(5),
    PAGAMENTO_CANCELADO(6);

    private int codigo;

    public int getCodigo(){
        return codigo;
    }

    private StatusPagamento(int codigo){
        this.codigo = codigo;
    }

    public static StatusPagamento valueOf(int codigo){
        for(StatusPagamento value: StatusPagamento.values()){
            if(codigo == value.getCodigo()){
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo invalido - StatusPagamento");
    }


}
