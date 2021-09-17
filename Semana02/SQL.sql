/*
Sentencia SELECT
==============================================================

WITH 
<iden1> AS <SELECT>,
<iden2> AS <SELECT> ,
etc.
SELECT <lista de columnas>
FROM <tbalas>
WHERE <filtro de filas>
GROUP BY <lista de columnas>
HAVING <filtro de grupos>
ORDER BY <lista de columnas>

*/


/* PROBELMA 01 */
/*
Desarrollar una sentencia SELECT que permita obtener 
el importe que se obtendría si se logra vender todas 
las vacantes por cada curso. Base de datos EDUCA.
*/
/*
Por curso se multiplica el precio o las vacantes programadas.
*/

SELECT cur_id, cur_nombre, cur_vacantes * cur_precio [Lo Programado]
FROM EDUCA.DBO.CURSO;
GO

SELECT sum(cur_vacantes * cur_precio) [Lo Programado]
FROM EDUCA.DBO.CURSO;
GO

select sum(mat_precio) from educa.dbo.MATRICULA;
go

select sum(pag_importe) from educa.dbo.PAGO;
go

/*
- Lo programado  => 242400.00
- Lo proyectado  =>   8200.00   =>   100000.00
- Lo recaudado   =>   5110.00   =>    45000.00
*/


/*
Desarrollar una sentencia SELECT para consultar 
los empleados del departamento de contabilidad. 
Base de datos RH.
*/

-- Solucion 1
-- ---------------------------------------------------

select * from rh.dbo.departamento;
go

-- Contabilidad: 101

select * from rh.dbo.empleado
where iddepartamento = 101;
go

-- Solucion 2
-- ---------------------------------------------------

select * from rh.dbo.empleado
where iddepartamento = (
	select iddepartamento from rh.dbo.departamento
	where nombre = 'contabilidad'
);
go


-- Solucion 3
-- ---------------------------------------------------

with 
v1 as (
	select iddepartamento from rh.dbo.departamento
	where nombre = 'contabilidad'
)
select e.* 
from rh.dbo.empleado e
join v1 on e.iddepartamento = v1.iddepartamento;
go


-- FUNCIONES AGREGADAS
-- Hacer estadistica descriptiva
-- ================================================================
/*
   - sum
   - max
   - min
   - count
   - avg
   - std
   - stdn
   - var
   - varn
*/

select 
	count(1) [Cant. Estudiantes] ,
	sum(mat_precio) [Importe Proyectado] 
from educa.dbo.MATRICULA;
go

/*
Desarrolle una sentencia SELECT para encontrar el mayor 
y menor sueldo en el departamento de ventas. 
Base de datos RH.
*/

select
	max(sueldo) [Sueldo Mayor],
	avg(sueldo) [Sueldo Promedio],
	min(sueldo) [Sueldo Menor]
from rh.dbo.empleado;
go

select
	iddepartamento,
	max(sueldo) [Sueldo Mayor],
	avg(sueldo) [Sueldo Promedio],
	min(sueldo) [Sueldo Menor]
from rh.dbo.empleado
group by iddepartamento;
go

/*
Desarrolle una sentencia SELECT para encontrar la 
cantidad de trabajadores por departamento. 
Base de datos RH.
*/

select 
	iddepartamento,
	count(1) [Cant. Trabajadores]
from rh.dbo.empleado
group by iddepartamento;
go

/*
Quien es el empleado con menor salario
en cada departamento. 
Base de datos RH.
*/










