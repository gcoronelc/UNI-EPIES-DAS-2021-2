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


/*

BASE DE DATOS: EDUCA

Desarrollar una consulta que permita obtener el siguiente resultado:

NOMBRE DEL CURSO      MATRICULADOS   COMPROMETIDO    PAGADO
------------------------------------------------------------------
SQL SERVER ADM.          5            4,250.00       3,310.00


SELECT * FROM EDUCA.DBO.MATRICULA WHERE CUR_ID=2;
SELECT * FROM EDUCA.DBO.PAGO WHERE CUR_ID=2;
SELECT * FROM EDUCA.DBO.CURSO;

*/



/*
Encontrar el empleado que tiene el menor salario por departamento. 
Base de datos RH
*/

-- Work

SELECT iddepartamento, MIN(SUELDO) SUELDO_MINIMO
FROM RH.DBO.empleado
group by iddepartamento;
go

-- Solucion 1

select e.* 
from rh.dbo.empleado e
join (
	SELECT iddepartamento, MIN(SUELDO) SUELDO_MINIMO
	FROM RH.DBO.empleado
	group by iddepartamento ) t
on e.iddepartamento = t.iddepartamento and e.sueldo = t.SUELDO_MINIMO;
go

-- Solución 2

with 
v1 as (
	SELECT iddepartamento, MIN(SUELDO) SUELDO_MINIMO
	FROM RH.DBO.empleado
	group by iddepartamento 
)
select e.* 
from rh.dbo.empleado e
join v1 on e.iddepartamento = v1.iddepartamento and e.sueldo = v1.SUELDO_MINIMO;
go



/*
Calcular los ingresos por mes de un determinado año, por curso.
Base de datos: EDUTEC

NOMBRE CURSO      ENERO    FEBRERO   MARZO ..... TOTAL
----------------------------------------------------------------

*/


SELECT 
	C.NomCurso [NOMBRE CURSO],
	SUM(CASE WHEN MONTH(M.FecMatricula)=1 THEN CP.PreCursoProg ELSE 0 END) [ENERO],
	SUM(CASE WHEN MONTH(M.FecMatricula)=2 THEN CP.PreCursoProg ELSE 0 END) [FEBRERO],
	SUM(CASE WHEN MONTH(M.FecMatricula)=3 THEN CP.PreCursoProg ELSE 0 END) [MARZO],
	SUM(CP.PreCursoProg) [TOTAL]
FROM EDUTEC.DBO.Curso C
JOIN EDUTEC.DBO.CursoProgramado CP ON C.IdCurso = CP.IdCurso
JOIN EDUTEC.DBO.Matricula M ON CP.IdCursoProg = M.IdCursoProg
WHERE YEAR(M.FecMatricula) = 2020
GROUP BY C.NomCurso;
GO

