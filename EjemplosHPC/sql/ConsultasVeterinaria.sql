use veterinaria;
-- 1. Nombre y descripción de las mascotas que son gatos.
SELECT mas_nombre, mas_des_social FROM mascota WHERE mas_tipo = 'Gato';
-- 2. Tipo y nombre de las mascotas que son juguetones.
SELECT mas_tipo, mas_nombre FROM mascota WHERE mas_des_social like '%Juguetón%';
-- 3. Nombres de los productos que contienen carne.
SELECT pro_nombre FROM producto WHERE upper(pro_nombre) like '%CARNE%';
-- 4. Nombre de las mascotas que han tenido servicio de peluqueria.
SELECT mas_nombre FROM mascota natural join factura natural join servicio where ser_id ='P';
-- 5. Nombre de los dueños y las mascotas a los que se les ha vendido productos.
SELECT cli_nombre, mas_nombre FROM mascota join cliente on cliente.cli_id = mascota.mas_dueno natural join factura;
-- 6. Nombre de los empleados que han realizado servicio de Guardería.
SELECT emp_nombre from empleado natural join factura join servicio on factura.ser_id = servicio.ser_id WHERE servicio.ser_id = 'G';
-- 7. Contar cuantas mascotas hay por cada uno de los tipos de mascotas. Proyectar el tipo y el conteo.
SELECT mas_tipo, count(mas_id) as "Conteo mascotas" from mascota group by mas_tipo;
-- 8. Calcular el promedio de los precios de los productos para los perros.
SELECT AVG(p.pro_costo) FROM producto p  join factura_venta fv on p.pro_id = fv.fact_vta_producto join factura f on
f.fact_id = fv.fact_vta_id join mascota m on f.mas_id = m.mas_id WHERE mas_tipo = 'Perro';
-- 9. Calcular el promedio de las ventas realizadas a los gatos
SELECT AVG(f.fact_costo) FROM producto p  join factura_venta fv on p.pro_id = fv.fact_vta_producto join factura f on
f.fact_id = fv.fact_vta_id join mascota m on f.mas_id = m.mas_id WHERE mas_tipo = 'Gato';
-- 10. Calcular cuantos servicios ha tenido la mascota llamada "Max".
SELECT count(ser_id) FROM mascota natural join factura WHERE mas_nombre = 'Max';
-- 11. Calcular el promedio de las ventas realizadas por cada uno de los tipos de servicios.
SELECT ser_id, avg(fact_costo)  from factura join factura_venta group by ser_id;
-- 12. Calcular cuantas mascotas tienen cada uno de las personas que tienen mascotas.
SELECT MAS_DUENO, COUNT(mas_id) FROM MASCOTA group by mas_dueno;