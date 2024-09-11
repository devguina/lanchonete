
-- Se ainda não estiver instalada, instale a extensão uuid-ossp para gerar UUIDs
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE tb_cliente (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),  -- Gerar um UUID padrão
    nome VARCHAR(255) NOT NULL,                     -- String para o nome do cliente
    rua VARCHAR(255),                               -- String para a rua
    numero_casa INT,                               -- Inteiro para o número da casa
    bairro VARCHAR(255),                           -- String para o bairro
    cidade VARCHAR(255),                           -- String para a cidade
    telefone CHAR(20)                              -- Char com tamanho 20 para o telefone
);

CREATE TABLE tb_lanche (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),  -- Gerar um UUID padrão
    nome_lanche VARCHAR(255) NOT NULL,               -- String para o nome do lanche
    ingredientes TEXT,                              -- String para os ingredientes
    valor_lanche FLOAT                              -- Float para o valor do lanche
);
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'forma_pagamento') THEN
        CREATE TYPE forma_pagamento AS ENUM ('dinheiro', 'cartao', 'pix');
    END IF;

    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'status_pedido') THEN
        CREATE TYPE status_pedido AS ENUM ('pendente', 'em_preparacao', 'concluido', 'cancelado');
    END IF;

    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'forma_entrega') THEN
        CREATE TYPE forma_entrega AS ENUM ('retirada', 'entrega');
    END IF;
END $$;

-- Criação da tabela Pedido
CREATE TABLE tb_pedido (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),           -- Gerar um UUID padrão
    id_lanche UUID REFERENCES tb_lanche(id) ON DELETE SET NULL, -- Chave estrangeira para tb_lanche
    id_cliente UUID REFERENCES tb_cliente(id) ON DELETE SET NULL, -- Chave estrangeira para tb_cliente
    forma_pagamento forma_pagamento NOT NULL,                 -- ENUM para forma de pagamento
    status_pedido status_pedido NOT NULL,                     -- ENUM para status do pedido
    forma_entrega forma_entrega NOT NULL                      -- ENUM para forma de entrega
);

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'cargo_funcionario') THEN
        CREATE TYPE cargo_funcionario AS ENUM ('gerente', 'cozinheiro', 'atendente', 'entregador');
    END IF;
END $$;

-- Criação da tabela tb_funcionario
CREATE TABLE tb_funcionario (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),            -- Gerar um UUID padrão
    login_funcionario VARCHAR(255) UNIQUE NOT NULL,           -- String para o login do funcionário, único e não nulo
    senha_funcionario VARCHAR(255) NOT NULL,                  -- String para a senha do funcionário, não nula
    cargo_funcionario cargo_funcionario NOT NULL               -- ENUM para o cargo do funcionário
);
