package com.projeto.lanchonete.models.enums.pedido;

public enum FormaDeEntrega {
    RETIRADA(1),
    ENTREGA(2);

    private int codigo;

    private FormaDeEntrega(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public static FormaDeEntrega valueOf(int codigo){
        for(FormaDeEntrega value: FormaDeEntrega.values()){
            if(codigo == value.getCodigo()){
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo Invalido - FormaDeEntrega");
    }
}
