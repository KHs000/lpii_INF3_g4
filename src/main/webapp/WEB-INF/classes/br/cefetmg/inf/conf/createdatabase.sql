DROP TABLE IF EXISTS aluno;

CREATE TABLE aluno (
    id bigserial CONSTRAINT aluno_pkey PRIMARY KEY,
    nome text,
    cpf bigint,
    endereco text,
    telefone text,
    CONSTRAINT unq_cpf UNIQUE(cpf)
);