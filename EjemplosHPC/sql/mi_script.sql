CREATE SCHEMA libreria;

USE libreria;
drop table venta;
CREATE TABLE venta(
	vta_fatura integer AUTO_INCREMENT primary key,
	vta_id_cliente integer NOT NULL,
	vta_total numeric(10,2)NULL,
	vta_pago ENUM('Efectivo','Tarjeta Credito','Tarjeta Debito','Transferencia','PSE'),
	vta_trans varchar(20) DEFAULT "Electronica"
);

create table cliente (
	cli_id integer AUTO_INCREMENT primary key,
    cli_nombre varchar(30) not null
);



insert into venta (vta_fatura, vta_id_cliente, 
     vta_total, vta_pago, vta_trans) values (1, 1, 25000, 'Efectivo', 'Electronica') ;

insert into venta (vta_fatura, vta_id_cliente, 
     vta_total, vta_pago) values (2, 1, 55000, 'Efectivo') ;
     
insert into venta (vta_fatura, vta_id_cliente, 
     vta_total, vta_pago) values (3, 3, 155000, 'Efectivo') ;

UPDATE venta SET vta_total = 1000000 WHERE vta_fatura = 1;

UPDATE venta SET vta_total = 1550000, vta_pago = 'PSE' WHERE vta_fatura = 1;

UPDATE venta SET vta_pago = 'PSE' ;

DELETE FROM venta WHERE vta_total < 100000;

ALTER TABLE venta ADD fecha_venta date null;

alter table venta drop fecha_venta;

alter table venta rename column vta_trans to vta_transferencia;
insert into cliente values (1,'pedro');
insert into cliente values (2,'maria');
insert into cliente values (3,'jose');

alter table venta add cliente_id integer;
alter table venta add constraint cliente_id FOREIGN KEY (cliente_id) REFERENCES cliente(cli_id);

update venta set cliente_id = 1 where vta_fatura = 1;

update venta set cliente_id = 10 where vta_fatura = 2;

update venta set cliente_id = 3 where vta_fatura = 1;

update venta set cliente_id = 3 where vta_fatura = 3;

