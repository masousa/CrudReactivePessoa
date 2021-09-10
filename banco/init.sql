CREATE TABLE pessoa (
  id serial NOT NULL primary key,
  nome character varying(255),
  idade int default 0,
  cep character varying(255),
  numero character varying(255),
  complemento character varying(255)
);


ALTER TABLE public.pessoa OWNER TO teste;

CREATE TABLE telefone (
 id serial NOT NULL primary key,
 numero character varying(255),
 id_pessoa int not null,
 constraint fk_pessoa_telefone foreign key (id_pessoa) references pessoa(id)

);

ALTER TABLE public.telefone OWNER TO teste;

