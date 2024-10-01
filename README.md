
# lanchonete
CONTEXT-PATH = /lanchonete
localhost:8787/lanchonete

END POINTS

    CONTROLLER =/api - RequestMapping

    METHODS:
        POST = /cliente
        localhost:8787/lanchonete/api/cliente

        GET ALL = /cliente/all
        localhost:8787/lanchonete/api/cliente/all

        GET = /cliente/{id}
        localhost:8787/lanchonete/api/cliente/{id}

        PUT = /cliente/update/{id}
        localhost:8787/lanchonete/api/cliente/update/{id}

        DELETE = /cliente/delete/{id}
        localhost:8787/lanchonete/api/cliente/delete/{id}


Exemplo de um POST ou o retorno de um GET no POSTAM
(ID não é necessário passar pra criar ou retornar)
ID está sendo gerado automáticamente


{
        "nomeCliente": "guilherme",
        "ruaCliente": "a",
        "bairroCliente": "a",
        "cidadeCliente": "a",
        "numeroCasaCliente": 12,
        "numeroTelefoneCliente": "a                   ",
        "emailCliente": "a"
    }