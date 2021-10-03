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
	cast(round(p.Importe*100.0/st.ImporteTotal,2) as decimal(12,2)) Porcentaje
from Northwind.dbo.Employees e
join Pedidos p on e.EmployeeID = p.EmployeeID
cross join SumaTotal st
order by 1;
go




/*
PREGUNTA 02
--------------------------------------------------------------------------
Se necesita saber cuál es el producto más solicitado en cada ciudad, se debe 
mostrar los empates. 
El modelo del resultado es el siguiente:
- NOMBRE CIUDAD
- NOMBRE PRODUCTO
- CANTIDAD PEDIDOS
- CANTIDAD PRODUCTOS

ANALISIS
--------------------------------------------------------------------------
	- NOMBRE CIUDAD
	- NOMBRE PRODUCTO
	- CANTIDAD PEDIDOS    - Orders
	- CANTIDAD PRODUCTOS  - [Order Details]

*/


with 
Pedidos as (
	select 
		c.City, od.ProductID,
		count(distinct o.OrderID) Pedidos,
		sum(od.Quantity) Productos
	from Northwind.dbo.Customers c
	join Northwind.dbo.Orders o on c.CustomerID=o.CustomerID
	join Northwind.dbo.[Order Details] od on o.OrderID = od.OrderID
	group by c.City, od.ProductID
),
MasSolicitados as (
	select City,  max(Pedidos) Pedidos
	from Pedidos 
	group by City
)
select p.City, a.ProductName, p.Pedidos, p.Productos
from Pedidos p 
join MasSolicitados ms
on p.City=ms.City and p.Pedidos = ms.Pedidos
join Northwind.dbo.Products a on p.ProductID = a.ProductID
order by 1;
go


/*
PREGUNTA 03
--------------------------------------------------------------------------
Se necesita saber las ventas totales por producto, en cada región. 
El modelo del resultado es el siguiente:
- NOMBRE REGIÓN
- NOMBRE PRODUCTO
- CANTIDAD
- IMPORTE
*/

SELECT
	C.Region, P.ProductName,
	SUM(OD.Quantity) Pedidos,
	sum(od.Quantity*od.UnitPrice) Importe
FROM Northwind.dbo.Customers C
JOIN Northwind.dbo.Orders O ON C.CustomerID = O.CustomerID
JOIN Northwind.DBO.[Order Details] OD ON O.OrderID = OD.OrderID
JOIN Northwind.DBO.Products p ON OD.ProductID = P.ProductID
group by C.Region, P.ProductName;
go

