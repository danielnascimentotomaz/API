CREATE TABLE tb_customer (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   cpf VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   income DECIMAL NOT NULL,
   zip_code VARCHAR(255) NOT NULL,
   street VARCHAR(255) NOT NULL,
   CONSTRAINT pk_tb_customer PRIMARY KEY (id)
);

ALTER TABLE tb_customer ADD CONSTRAINT uc_tb_customer_cpf UNIQUE (cpf);

ALTER TABLE tb_customer ADD CONSTRAINT uc_tb_customer_email UNIQUE (email);