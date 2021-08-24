-- Mo d i f i c a r l a columna de c o s t o de obra de jando por d e f e c t o e l v a l o r 500
ALTER TABLE obra ALTER ob_costo SET DEFAULT 500 ;
-- I n s e r t a r una nueva obra de Da Vi n obrac i s i n c o s t o ( v e r i f i c a r que t enga e l v a l o r por
-- d e f e c t o despue s de l a i n s e r c ion )
INSERT INTO obra ( ob_id , ob_nombre , ob_tipo , ob_ex_id ) values (115 , 'Salvatore Mundi' , 'Pintura' , 1003) ;
-- I n c r eme n t a r e l p r e c i o de l a s e s c u l t u r a s en 10%
UPDATE obra SET ob_costo=ob_costo *1.1 WHERE ob_tipo = 'escultura' ;
-- Co n s u l t a r l o s nombres de l a s ob r a s con su c o r r e s p o n d i e n t e t i p o
SELECT ob_nombre AS 'Nombre de la obra', ob_tipo AS 'Tipo de Obra' FROM obra ;
-- Co n s u l t a r l o s d i f e r e n t e s t i p o s de o br a s s i n r e p e t i d o s y renombrando e l a t r i b u t o por TIPO
SELECT DISTINCT ob_tipo AS TIPO FROM obra ;

SELECT  ob_tipo AS TIPO FROM obra ;

select * from obra;

-- Ex p l i q u e l o que r e a l i z a l a s i g u i e n t e e x p r e s ion :
SELECT ob_nombre FROM obra WHERE ob_nombre LIKE '%ma%' AND ob_nombre NOT LIKE '%cena%';
-- L i s t a r t oda s l o s nombres de l a s o b r a s en mayu s c u l a
SELECT UPPER( ob_nombre ) FROM obra ;
-- S e l e c c i o n a l a s o b r a s cuyo c o s t o e s mayor a l promedio de l o s c o s t o s
SELECT ob_costo FROM obra WHERE ob_costo > (SELECT AVG( ob_costo ) FROM obra ) ;
-- Nombre de l a s 5 o br a s ma s c o s t o s a s
SELECT ob_nombre, ob_costo FROM obra ORDER BY ob_costo DESC LIMIT 5;
-- Contar e l numero de ob r a s por cada uno de l o s t i p o s de o b r a s
SELECT ob_tipo , count(ob_id) FROM obra GROUP BY ob_tipo ;
--  L i s t a r l o s nombres de l a s ob r a s y e x p o s i c i o n e s de l a s o br a s t i p o p i n t u r a
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

-- Con JOINS
SELECT ob_nombre, ob_tipo, ob_costo from obra join exposicion on obra.ob_ex_id = exposicion.ex_id
WHERE exposicion.ex_nombre = 'Da Vinci';

DESCRIBE obra;

select * from obra;