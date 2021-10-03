/*
PREGUNTA 01
--------------------------------------------------------------------------
Se necesita saber la cantidad de pedidos que ha atendido cada empleado, 
que incluya la cantidad de artículos, el importe respectivo y el porcentaje 
que representa del total de pedidos. 
El modelo del resultado es el siguiente:
  - CODIGO EMPLEADO
  - NOMBRE EMPLEADO
  - CANTIDAD PEDIDOS
  - CANTIDAD PRODUCTOS
  - IMPORTE
  - PORCENTAJE DEL TOTAL

ANALISIS
--------------------------------------------------------------------------
  - CODIGO EMPLEADO
  - NOMBRE EMPLEADO
  - CANTIDAD PEDIDOS       -  Orders
  - CANTIDAD PRODUCTOS     - [Order Details]
  - IMPORTE                - [Order Details]
  - PORCENTAJE DEL TOTAL   - [Order Details]

*/

WITH
Pedidos as (
	select 
		o.EmployeeID, 
		COUNT(distinct o.OrderID) Pedidos,
		SUM(od.Quantity) Productos,
		SUM(UnitPrice*Quantity) Importe
	from Northwind.dbo.Orders o
	join Northwind.dbo.[Order Details] od
	on o.OrderID = od.OrderID
	group by o.EmployeeID 
),
SumaTotal as (
	select sum(Importe) ImporteTotal
	from Pedidos
)
select 
	e.EmployeeID, e.FirstName, e.LastName,
	p.Pedidos, p.Productos, p.Importe,
	p.Importe*100.0/st.ImporteTotal Porcentaje
from Northwind.dbo.Employees e
join Pedidos p on e.EmployeeID = p.EmployeeID
cross join SumaTotal st
order by 1








