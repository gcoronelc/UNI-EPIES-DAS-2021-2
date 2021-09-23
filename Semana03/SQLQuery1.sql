-- GROUP BY Y HAVING
-- ===========================================

/*
Desarrolle una sentencia SELECT para encontrar los departamentos 
que tienen más de 5 trabajadores. Base de datos RH.
*/

-- Solucion 1

select iddepartamento, count(1) trabajadores
from rh.dbo.empleado
group by iddepartamento
having count(1) > 5;
go


-- Solucion 2

with 
v1 as (
	select iddepartamento, count(1) trabajadores
	from rh.dbo.empleado
	group by iddepartamento
)
select * from v1
where trabajadores >  5;
go

/*
A la consulta anterior agregarle el nombre del departamento.
*/

-- Solucion 1

select e.iddepartamento, d.nombre, count(1) trabajadores
from rh.dbo.empleado e
join rh.dbo.departamento d on e.iddepartamento = d.iddepartamento
group by e.iddepartamento, d.nombre
having count(1) > 5;
go


-- Solucion 2

with 
v1 as (
	select iddepartamento, count(1) trabajadores
	from rh.dbo.empleado
	group by iddepartamento
)
select v1.iddepartamento, d.nombre, v1.trabajadores
from v1 
join rh.dbo.departamento d on v1.iddepartamento = d.iddepartamento 
where v1.trabajadores >  5;
go



/*
Desarrolle una sentencia SELECT para obtener un listado que incluya 
el nombre del curso con sus respectivos nombres de alumnos. 
Base de datos EDUCA.

DISEÑO DEL RESULTADO

NOMBRE DEL CURSO           NOMBRE DEL ALUMNO
---------------------------------------------------

*/


SELECT C.cur_nombre, A.alu_nombre
FROM EDUCA.DBO.CURSO C
JOIN EDUCA.DBO.MATRICULA M ON C.cur_id = M.cur_id
JOIN EDUCA.DBO.ALUMNO A ON M.alu_id = A.alu_id;
GO


/*
Desarrolle una sentencia SELECT para encontrar la cantidad de
trabajadores en cada ciudad. Base de datos RH.
*/

SELECT * 
FROM rh.dbo.ubicacion u
join rh.dbo.departamento d on u.idubicacion = d.idubicacion 
join rh.dbo.empleado e on d.iddepartamento = e.iddepartamento;
go

SELECT u.ciudad, count(1) Trabajadores
FROM rh.dbo.ubicacion u
join rh.dbo.departamento d on u.idubicacion = d.idubicacion 
join rh.dbo.empleado e on d.iddepartamento = e.iddepartamento
group by u.ciudad;
go




