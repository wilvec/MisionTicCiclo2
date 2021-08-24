USE libreria;
SELECT libNombre FROM libro ;
SELECT libNombre , libPub FROM libro ;
SELECT * FROM autor ;
SELECT * FROM libro ;

-- Selecciona todos los atributos del libro con identificador 1003
SELECT * FROM libro WHERE libId=1003;

-- Selecciona todos los atributos de los libros que fueron publicados despues de 1960
SELECT * FROM libro WHERE libPub > 1960;

-- Selecciona todos los atributos de los libros que continen la cadena "los".
SELECT * FROM libro WHERE libNombre LIKE "%los%" ;


-- selecciona todos los atributos de los libros que inicien con la letra "C" y no tienen
-- la cadena "los".
SELECT * FROM libro WHERE libNombre LIKE "C%" and libNombre NOT LIKE "%los%" ;
SELECT * FROM libro WHERE libNombre LIKE "%sol%" ;
SELECT * FROM libro WHERE libNombre LIKE "%a_os%" ; 
SELECT * FROM libro WHERE LENGTH(libNombre) > 28 ;
SELECT * FROM libro WHERE LOWER(libNombre) LIKE "maría" ;
SELECT libNombre, libPub FROM libro WHERE libNombre LIKE "C%" and libNombre NOT LIKE "%los%" ;

-- Selecciona los tres primeros nombres de los libros ordenados por año de publicación
-- descendentemente
SELECT libNombre FROM libro ORDER BY libPub DESC LIMIT 2 ;
-- INSERT [(campo1t1,campo2t2,...)] INTO TABLA1 SELECT <CAMPO1, CAMPO2,...> FROM TABLA2

-- Selecciona el año más reciente de publicacion
SELECT MAX(libPub) FROM libro ;

-- Selecciona el precio promedio de los libros
SELECT AVG(libPrecio) FROM libro ;

-- Cuenta los libros
SELECT count(libId) from libro ;

-- Selecciona el nombre del libro mas costoso
SELECT libNombre FROM libro WHERE libPrecio = (SELECT MAX(libPrecio) FROM libro);

SELECT libNombre FROM libro WHERE libPrecio IN (SELECT libPrecio FROM libro);

SELECT * FROM venta;
-- Cuenta las ventas por cada libId
SELECT libId, COUNT(vtaId) FROM venta GROUP BY (libId) ;

SELECT libId, SUM(vtaTotal) FROM venta  GROUP BY (libId) ;

-- Cuenta las ventas por cada libId y selecciona los que tienen ventas mayores a 3
SELECT libId , COUNT(vtaId) FROM venta GROUP BY ( libId ) HAVING COUNT(vtaId) > 3;

-- Selecciona el identificador y el nombre de los libros que fueron publicados despues de
-- 1960 , y los renombra .
SELECT libId AS "Código del libro" , libNombre AS "Título" FROM libro WHERE libPub > 1960;


-- Renombra el nombre de la tabla LIBRO por LIBRO2 y luego proyecta los nombres
-- de los libros
SELECT libNombre AS "Título" FROM libro AS libro2 ;


-- Selecciona nombres y apellidos del autor , los concatena y los proyecta con otro nombre
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
-- JOIN de tres relaciones . nombre del libro , de la editorial y del autor de todos los
-- libros.
SELECT libNombre , ediNombre , autNombre , autApellido FROM libro NATURAL JOIN editorial
NATURAL JOIN autor ;

select * from autor;

-- Paises de la nacionalidad de los autores
SELECT distinct autPais AS "País" FROM autor;


-- Total de libros vendidos en el año 2021
SELECT sum( vtaCantidad ) AS "Cantidad" FROM venta WHERE year(vtaFecha) > 2020;
