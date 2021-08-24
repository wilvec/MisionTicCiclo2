USE museo;

-- Modificar la columna de costo de obra dejando por defecto el valor 500
ALTER TABLE obra ALTER ob_costo SET DEFAULT 500 ;
-- Insertar una nueva obra de Da Vinci sin costo (verificar que tenga el valor por defecto despues de la insercion)
INSERT INTO obra ( ob_id , ob_nombre , ob_tipo , ob_ex_id ) values (115 , 'Salvatori Mundi' , 'pintura' , 1003) ;

select * from obra where ob_id = 115;

-- Incrementar el precio de las esculturas  en 10%
UPDATE obra SET ob_costo=ob_costo * 1.1 WHERE ob_tipo = 'escultura' ;

UPDATE OBRA SET ob_tipo = 'ESTE DATO NO EXISTE OJO!!' where ob_id = 115;

select * from obra;
-- Sentencia Para confirmar los cambios
COMMIT ;
-- Sentencia Para devolver los cambios
ROLLBACK;

--  Consultar los nombres de las obras con su correspondiente tipo
SELECT ob_nombre , ob_tipo FROM obra ;
-- Consultar los diferentes tipos de obras sin repetidos y renombrando el atributo por TIPO
SELECT DISTINCT obr_tipo AS TIPO FROM obra ;

select * from obra;

-- Explique lo que realiza la siguiente expresion :
SELECT ob_nombre FROM obra WHERE ob_nombre LIKE '%ma%' AND ob_nombre NOT LIKE '%cena%';
-- Listar todas los nombres de las obras en mayuscula
SELECT UPPER( ob_nombre ) FROM obra ;
-- Selecciona las obras cuyo costo es mayor al promedio de los costos
SELECT ob_costo FROM obra WHERE ob_costo > (SELECT AVG( ob_costo ) FROM obra ) ;
-- Nombre de las 5 obras mas costosas
SELECT ob_nombre, ob_costo FROM obra ORDER BY ob_costo DESC LIMIT 5;
-- Contar el numero de obras por cada uno de los tipos  de obras
SELECT ob_tipo , count(ob_id) FROM obra GROUP BY ob_tipo ;
--  Listar los nombres de las obras y exposiciones de las obras de tipo pintura
SELECT ob_nombre , exp_nombre FROM obra JOIN exposicion USING ( ex_id ) WHERE ob_tipo = 'pintura' ;
-- Se usa el ON
SELECT ob_nombre , ex_nombre FROM obra JOIN exposicion ON obra.ob_ex_id = exposicion.ex_id WHERE ob_tipo = 'pintura' ;

-- ---- PROBLEMAS
-- 1. Nombre de las obras que tienen un costo menor a 1/3 del promedio.
select ob_nombre FROM obra WHERE ob_costo < ((SELECT AVG(ob_costo) FROM obra) / 3);
-- SELECT AVG(ob_costo) / 3 FROM obra;
-- 2. Listar los nombres de las obras ordenadas alfabéticamente
SELECT ob_nombre FROM obra ORDER BY ob_nombre ;
-- 3. Sumar el costo de las obras por tipo de obra
SELECT ob_tipo, SUM(ob_costo) FROM obra GROUP BY ob_tipo;
-- 4. Contar las obras que tiene cada una de las exposiciones
SELECT count(ob_id),  ob_ex_id FROM obra GROUP BY ob_ex_id;
-- 5. Listar los nombres, tipo y costo de las obras de la exposicion daVinci
SELECT * FROM exposicion;
-- 1003
SELECT ob_nombre, ob_tipo, ob_costo from obra where ob_ex_id = 1003;

-- 6. Proyectar nombre del museo, nombre de la obra de las presentaciones de las obras de \Da Vinci"
SELECT  museo.mu_nombre as "Nombre del museo", obra.ob_nombre as "Nombre de la obra" FROM obra join presentacion on obra.ob_id = presentacion.pre_ob_id join museo on museo.mu_id = presentacion.pre_mu_id;





-- Con JOINS
SELECT ob_nombre, ob_tipo, ob_costo from obra join exposicion on obra.ob_ex_id = exposicion.ex_id
WHERE exposicion.ex_nombre = 'Da Vinci';

DESCRIBE obra;

select * from obra;