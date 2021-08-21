CREATE SCHEMA libreria ;

USE libreria ;

CREATE TABLE libro (
libId integer NOT NULL PRIMARY KEY ,
libNombre char (50 ) NOT NULL ,
libPub smallint NULL
) ;

CREATE TABLE autor (
autId integer AUTO_INCREMENT PRIMARY KEY,
autApellido varchar (30 ) NOT NULL DEFAULT "" ,
autNombre varchar (50 ) NOT NULL ,
autEmail char (30 ) NULL ,
autPais ENUM ( 'Argentina' , 'Alemania' , 'Colombia', 'Italia', 'Mexico' ,'Espana','EUA')
DEFAULT "Colombia"
) ;

CREATE TABLE venta (
vtaId integer AUTO_INCREMENT PRIMARY KEY ,
vtaFecha date NOT NULL ,
libId integer NOT NULL ,
vtaCantidad smallint NOT NULL ,
FOREIGN KEY ( libId ) REFERENCES libro ( libId ) ) ;

CREATE TABLE ventaError (
vtaId integer AUTO_INCREMENT PRIMARY KEY ,
vtaFecha date NOT NULL ,
libId integer NOT NULL ,
vtaCantidad smallint NOT NULL ,
FOREIGN KEY ( libId ) REFERENCES libro ( libId ) ) ;

drop table ventaError;

show tables;

show columns from venta;

describe venta;

INSERT INTO libro ( libId , libNombre , libPub ) VALUES ( 1, "El olvido que seremos " , 2005) ;
INSERT INTO libro VALUES (201 , "El renacuajo paseador" , 1867) ;

INSERT INTO libro ( libId , libNombre , libPub ) VALUES (1001 , "Cien anos de soledad" , 1967) ;
INSERT INTO libro ( libId , libNombre , libPub ) VALUES (1002 , "La Voragine" , 1924) ;
INSERT INTO libro ( libId , libNombre , libPub ) VALUES (1003 , "Maria" , 1867) ;

SELECT * FROM libro ;
SELECT * FROM autor ; 

-- I n s e r t a r l o s dos r e g i s t r o s en l a t a b l a Autor , s o l o s e i n s e r t a n nombre y a p e l l i d o .
INSERT INTO autor ( autApellido , autNombre ) VALUES ( "Garcia Marquez" , "Gabriel" ) ;
INSERT INTO autor ( autApellido , autNombre ) VALUES ( "Isaacs" , "Jorge" ) ;
-- I n s e r t a r un a u t o r con a u tPa i s
INSERT INTO autor ( autApellido , autNombre , autPais ) VALUES ("Alighieri" , "Dante" , "Italia" ) ;
-- I n s e r t a r un a u t o r con c o r r e o
INSERT INTO autor ( autApellido , autNombre , autEmail ) VALUES ( "Trueba" , "Fernando" , "ftrueba@gmail.com" ) ;
INSERT INTO autor ( autApellido , autNombre ) VALUES ( "Rivera" , "Jose Eustasio" ) ;

SELECT * FROM autor ; 

UPDATE libro SET libPub=2000 WHERE libId = 1003;

UPDATE libro SET libNombre = "La Casa Grande", libPub=1962 WHERE libId = 1003;

DELETE FROM libro where libPub < 1990;

alter table libro add libPrecio float(7,1) default 0;
describe libro;


describe libro;
alter table libro add fechaNto date;
ALTER TABLE libro DROP fechaNto ;


describe autor;
ALTER TABLE autor RENAME COLUMN autEmail TO autCorreo;

ALTER TABLE autor modify autCorreo VARCHAR(150);

describe libro;
ALTER table libro ADD autID integer ;

alter table libro add constraint autID FOREIGN KEY ( autID ) REFERENCES autor ( autID ) ;
-- FOREIGN KEY ( autID ) REFERENCES autor ( autID ) ;

select * from libro;
select * from autor;
UPDATE libro SET autID=1 WHERE libId=1;
UPDATE libro SET autID=15 WHERE libId=1;


