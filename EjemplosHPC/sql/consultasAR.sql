USE libreria;

SELECT libNombre FROM libro ;

SELECT libNombre , libPub FROM libro ;

SELECT * FROM autor ;


SELECT * FROM libro ;

-- S e l e c c i o n a todos l o s a t r i b u t o s d e l l i b r o con i d e n t i f i c a d o r 1003
SELECT * FROM libro WHERE libId=1003;


-- S e l e c c i o n a todos l o s a t r i b u t o s de l o s l i b r o s que f u e r o n p u b l i c a d o s de spue s de 1960
SELECT * FROM libro WHERE libPub > 1960;


-- S e l e c c i o n a todos l o s a t r i b u t o s de l o s l i b r o s que c o n t i n e n l a cadena " l o s " .
SELECT * FROM libro WHERE libNombre LIKE "%los%" ;


-- se l e c c i o n a todos l o s a t r i b u t o s de l o s l i b r o s que i n i c i e n con l a l e t r a "C" y no t i e n e n
-- l a cadena " l o s " .
SELECT * FROM libro WHERE libNombre LIKE "C%" and libNombre NOT LIKE "%los%" ;


SELECT * FROM libro WHERE libNombre LIKE "%sol%" ;

SELECT * FROM libro WHERE libNombre LIKE "%a_os%" ; 


SELECT * FROM libro WHERE LENGTH(libNombre) > 28 ;

SELECT * FROM libro WHERE LOWER(libNombre) LIKE "maría" ;


SELECT libNombre, libPub FROM libro WHERE libNombre LIKE "C%" and libNombre NOT LIKE "%los%" ;

-- S e l e c c i o n a l o s t r e s p r ime r o s nombres de l o s l i b r o s ordenados por a~no de p u b l i c a c i on
-- de s c endent ement e
SELECT libNombre FROM libro ORDER BY libPub DESC LIMIT 2 ;


-- INSERT [(campo1t1,campo2t2,...)] INTO TABLA1 SELECT <CAMPO1, CAMPO2,...> FROM TABLA2




-- S e l e c c i o n a e l ano ma s r e c i e n t e de p u b l i c a c i on
SELECT MAX(libPub) FROM libro ;
-- S e l e c c i o n a e l p r e c i o promedio de l o s l i b r o s
SELECT AVG(libPrecio) FROM libro ;
-- Cuenta l o s l i b r o s
SELECT count(libId) from libro ;
-- S e l e c c i o n a e l nombre d e l l i b r o ma s c o s t o s o

SELECT libNombre FROM libro WHERE libPrecio = (SELECT MAX(libPrecio) FROM libro);

SELECT libNombre FROM libro WHERE libPrecio IN (SELECT libPrecio FROM libro);

SELECT * FROM venta;
-- Cuenta l a s v e n t a s por cada l i b I d
SELECT libId, COUNT(vtaId) FROM venta GROUP BY (libId) ;

SELECT libId, SUM(vtaTotal) FROM venta  GROUP BY (libId) ;

-- Cuenta l a s v e n t a s por cada l i b I d y s e l e c c i o n a l o s que t i e n e n v e n t a s mayores a 3
SELECT libId , COUNT(vtaId) FROM venta GROUP BY ( libId ) HAVING COUNT(vtaId) > 3;


-- S e l e c c i o n a e l i d e n t i f i c a d o r y e l nombre de l o s l i b r o s que f u e r o n p u b l i c a d o s de spue s de
-- 1960 , y l o s renombra .
SELECT libId AS "Código del libro" , libNombre AS "Título" FROM libro WHERE libPub > 1960;


-- Renombra e l nombre de l a t a b l a LIBRO por LIBRO2 y l u e g o p r o y e c t a l o s nombres
-- de l o s l i b r o s
SELECT libNombre AS "Título" FROM libro AS libro2 ;


-- S e l e c c i o n a nombres y a p e l l i d o s d e l autor , l o s conc a t ena y l o s p r o y e c t a con o t r o nombre
SELECT concat ( autNombre , concat ( " " , autApellido ) ) AS "Nombres y apellidos Autor " FROM autor WHERE
autPais='Colombia' ;

SELECT * from autor, libro;

SELECT libNombre as 'Título' , autNombre , autApellido FROM libro , autor WHERE libro.autId=autor.autId ;

SELECT vtaFecha , libNombre FROM libro , venta WHERE libro.libId = venta.libId ;

SELECT libNombre , ediNombre FROM libro , editorial WHERE libro.ediId = editorial.ediId;

SELECT * FROM libro JOIN autor using ( autId ) ;

SELECT libNombre , autNombre , autApellido FROM libro JOIN autor using ( autId ) ;

SELECT libNombre , autNombre , autApellido FROM libro NATURAL JOIN autor ;

SELECT vtaFecha , libNombre , vtaCantidad FROM libro NATURAL JOIN venta ;

SELECT libNombre , ediNombre FROM libro JOIN editorial USING ( ediId ) ;
-- JOIN de t r e s r e l a c i o n e s . nombre d e l l i b r o , de l a e d i t o r i a l y d e l a u t o r de todos l o s
-- l i b r o s .
SELECT libNombre , ediNombre , autNombre , autApellido FROM libro NATURAL JOIN editorial
NATURAL JOIN autor ;

select * from autor;

-- Pa i s e s de l a n a c i o n a l i d a d de l o s a u t o r e s
SELECT distinct autPais AS "País" FROM autor;


-- Tot a l de l i b r o s v e n d i d o s en e l a~no 2021
SELECT sum( vtaCantidad ) AS "Cantidad" FROM venta WHERE year(vtaFecha) > 2020;
