-- Ínicio Farmacia Projeto PI --
create database farmacia;

use farmacia;

create table funcionarios(
 codf int(10) primary key auto_increment,
 idUsuario varchar(100) not null,
 senha varchar(100) not null,
 nome varchar(50) not null,
 cpf char (11) unique not null,
 logradoura varchar(100),
 num_resid varchar(10),
 complemento varchar(100),
 uf char(2),
 telefone varchar(100),
 email varchar(100) not null,
 função varchar(100) not null,
 salario float(10,2),
 perfil varchar(20));
 

create table clientes (
 cod_cli int(10)primary key auto_increment,
 nome varchar(100) not null,
 cpf char(11) unique not null,
 data_nascimento date,
 email varchar(100) not null,
 telefone varchar(100) not null,
 endereco varchar(100),
 complemento varchar(100),
 cidade varchar(100),
 uf char(2));
 
create table produtos (
 cod_produto int(10) primary key auto_increment,
 nome_prod varchar(100) not null,
 desc_prod varchar(100),
 val_unit double(10,2) not null,
 qtd_prod int(10) not null);


create table vendas (
 cod_venda int(10) primary key auto_increment,
 cod_cliente int(10) null,
 valor_bruto float(10,2)not null,
 desconto float(10,2)null,
 total float(10,2)not null,
 data_compra timestamp default CURRENT_TIMESTAMP,
 pagamento varchar(20),
 foreign key(cod_cliente) references clientes(cod_cli)
 );
 
 CREATE TABLE itemvenda (
  cod_itemvenda int(10) primary key not null AUTO_INCREMENT,
  cod_prod int(10) NOT NULL,
  cod_vend int(10) NOT NULL,
  qtd int(10) NOT NULL,
  valor_unitario decimal(10,2) NOT NULL,
FOREIGN KEY (cod_prod) REFERENCES produtos (cod_produto),
FOREIGN KEY (cod_vend) REFERENCES vendas (cod_venda)  
);

insert into funcionarios(nome,cpf,email,perfil,idUsuario,senha,função)
values("admin","xxxxxxxxx","admin@gmail.com","admin","admin","admin","administrador");


-- Fim Farmacia Projeto PI --
