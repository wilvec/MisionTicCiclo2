select * from libro;

--  S e l e c c i o n a e l año m a s r e c i e n t e de p u b l i c a c i on
SELECT MAX( libPub ) FROM libro ;


-- S e l e c c i o n a e l p r e c i o promedio de l o s l i b r o s
SELECT AVG ( libPrecio ) FROM libro ;

-- Cuenta l o s l i b r o s
SELECT count(libId) from libro ;

-- S e l e c c i o n a e l nombre d e l l i b r o ma s c o s t o s o
SELECT libNombre FROM libro WHERE libPrecio = (SELECT MAX(libPrecio ) FROM libro);

-- 
SELECT libNombre FROM libro WHERE libPrecio >  (SELECT libPrecio FROM libro) ;

SELECT * FROM libro WHERE libPub = (select min(libPub) from libro) AND  
libPrecio = (SELECT MIN(libPrecio ) FROM libro) ;

SELECT * FROM venta;
-- Cuenta l a s v e n t a s por cada l i b I d
select libId, count(vtaId) from venta group by libId;

select libId, sum(vtaCantidad) from venta group by libId;

select libId, count(vtaCantidad) from venta group by libId;

-- Ca l c u l a e l promedio de l o s l i b r o s por cada a u t o r
SELECT autId , AVG ( libPrecio ) FROM libro GROUP BY ( autId );

SELECT libId , COUNT( vtaId ) FROM venta GROUP BY ( libId )  HAVING COUNT( vtaId ) >= 3 ;
 
select * from venta;
 --  ;

SELECT * FROM venta WHERE year(vtaFecha) = 2021;
SELECT * FROM libro;






-- S e l e c c i o n a e l nombre d e l l i b r o con i d e n t i f i c a d o r 1003 y l o renombra por t  t u l o
SELECT libNombre AS titulo FROM libro WHERE libId=1003;
-- S e l e c c i o n a e l i d e n t i f i c a d o r y e l nombre de l o s l i b r o s que f u e r o n p u b l i c a d o s de spue s de
-- 1960 , y l o s renombra .
SELECT libId AS "Código" , libNombre AS "Título", libPub as "Año de publicación" FROM libro WHERE libPub > 1960;
-- Renombra e l nombre de l a t a b l a LIBRO por LIBRO2 y l u e g o p r o y e c t a l o s nombres
-- de l o s l i b r o s
SELECT libro2.libNombre AS "Título" FROM libro AS libro2;
-- S e l e c c i o n a nombres y a p e l l i d o s d e l autor , l o s conc a t ena y l o s p r o y e c t a con o t r o nombre
SELECT concat(autNombre, concat( " ", autApellido ) ) AS "Nombre completo de  autor" FROM autor WHERE
 autPais='Colombia' ;
 
 
 SELECT * FROM libro , autor ;
 
SELECT libNombre , concat(autNombre, concat( " ", autApellido ) ) AS "Nombre completo de  autor" FROM libro , autor WHERE libro.autId=autor.autId ;

SELECT vtaFecha , libNombre FROM libro , venta WHERE libro.libId = venta.libId ;

SELECT libNombre , ediNombre FROM libro , editorial WHERE libro.ediId = editorial.ediId ;
 
 
 SELECT * FROM libro JOIN autor using ( autId ) ;
 
 SELECT libNombre , autNombre , autApellido FROM libro JOIN autor using ( autId ) ;
 
 SELECT libNombre , autNombre , autApellido FROM libro NATURAL JOIN autor ;
 
SELECT vtaFecha , libNombre , vtaCantidad FROM libro NATURAL JOIN venta ;
SELECT libNombre , ediNombre FROM libro JOIN editorial USING ( ediId ) ;
-- JOIN de t r e s r e l a c i o n e s . nombre d e l l i b r o , de l a e d i t o r i a l y d e l a u t o r de todos l o s
-- l i b r o s .
SELECT libNombre , ediNombre , autNombre , autApellido FROM libro NATURAL JOIN editorial
NATURAL JOIN autor ;

-- Pa i s e s de l a n a c i o n a l i d a d de l o s a u t o r e s
SELECT DISTINCT autPais AS "Paises" FROM autor ;

-- Tot a l de l i b r o s v e n d i d o s en e l ano 2021
SELECT sum( vtaCantidad ) AS "Cantidad" FROM venta WHERE year( vtaFecha ) > 2020;


-- Tot a l de l i b r o s que t i e n e cada a u t o r
SELECT concat( autNombre , concat( " " , autApellido ) ) AS "Nombre Autor " , count( libId ) AS 
"Número" FROM libro NATURAL JOIN autor GROUP BY autId ;


-- Tot a l de u n i d a d e s v e n d i d a s por l i b r o . L i s t a r l a en orden d e s c e n d e n t e por l a c a n t i d a d
-- vendida .
SELECT libNombre , sum( vtaCantidad ) AS "Total" FROM libro NATURAL JOIN venta GROUP BY
libId ORDER BY Total DESC ;


