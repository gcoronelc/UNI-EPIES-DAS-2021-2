

select * from EMPLEADO;
go

sp_help empleado
go

select IDEMPLEADO, NOMBRE, APELLIDO, DNI,
TELEFONO, CORREO, IDROL, USUARIO, '******' CLAVE
from empleado 
where usuario='mcasasx' and clave='123456';
go