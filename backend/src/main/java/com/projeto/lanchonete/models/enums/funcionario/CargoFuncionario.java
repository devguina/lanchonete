package com.projeto.lanchonete.models.enums.funcionario;

public enum CargoFuncionario {
    ATENDENTE(1),
    ENTREGADOR(2),
    CHAPEIRO(3),
    GERENTE(4),
    DONO(5);

    private int codigo;

    private CargoFuncionario(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public static CargoFuncionario valueOf(int codigo){
        for (CargoFuncionario value: CargoFuncionario.values()){
            if(codigo == value.getCodigo()){
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo Inválido - CargoFuncionario");
    }

}
