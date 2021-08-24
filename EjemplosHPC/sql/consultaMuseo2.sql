USE museo;

-- Mo d i f i c a r l a columna de c o s t o de obra de jando por d e f e c t o e l v a l o r 500
ALTER TABLE obra ALTER ob_costo SET DEFAULT 500 ;
-- I n s e r t a r una nueva obra de Da Vi n c i s i n c o s t o ( v e r i f i c a r que t enga e l v a l o r por
-- d e f e c t o despu e s de l a i n s e r c i on )
INSERT INTO obra ( ob_id , ob_nombre , ob_tipo , ob_ex_id ) values (115 , 'Salvatori Mundi' , 'pintura' , 1003) ;

select * from obra where ob_id = 115;

-- I n c r eme n t a r e l p r e c i o de l a s e s c u l t u r a s en 10%
UPDATE obra SET ob_costo=ob_costo * 1.1 WHERE ob_tipo = 'escultura' ;

UPDATE OBRA SET ob_tipo = 'ESTE DATO NO EXISTE OJO!!' where ob_id = 115;

select * from obra;

COMMIT ;

ROLLBACK;

--  Co n s u l t a r l o s nombres de l a s ob r a s con su c o r r e s p o n d i e n t e t i p o
SELECT ob_nombre , ob_tipo FROM obra ;
-- Co n s u l t a r l o s d i f e r e n t e s t i p o s de o br a s s i n r e p e t i d o s y renombrando e l a t r i b u t o por TIPO
SELECT DISTINCT obr_tipo AS TIPO FROM obra ;

select * from obra;
SELECT ob_nombre FROM obra WHERE ob_nombre LIKE '%ma%' AND ob_nombre NOT LIKE '%cena%'

