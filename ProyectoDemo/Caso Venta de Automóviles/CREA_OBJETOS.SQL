
DROP TABLE dbo.AUTO
go



DROP TABLE dbo.MARCA
go



DROP TABLE dbo.CLIENTE
go



DROP TABLE dbo.TIPOREVISION
go



DROP TABLE dbo.EMPLEADO
go



DROP TABLE dbo.ROL
go



CREATE TABLE dbo.ROL
( 
	IDROL                integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	CONSTRAINT XPKROL PRIMARY KEY (IDROL ASC)
)
go



CREATE TABLE dbo.EMPLEADO
( 
	IDEMPLEADO           integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	APELLIDO             varchar(100)  NOT NULL ,
	DNI                  varchar(20)  NOT NULL ,
	TELEFONO             varchar(20)  NOT NULL ,
	CORREO               varchar(100)  NOT NULL ,
	IDROL                integer  NOT NULL ,
	USUARIO              varchar(20)  NOT NULL ,
	CLAVE                varchar(20)  NOT NULL ,
	CONSTRAINT XPKEMPLEADO PRIMARY KEY (IDEMPLEADO ASC),
	CONSTRAINT U_EMPLEADO_USUARIO UNIQUE (USUARIO  ASC),
	CONSTRAINT FK_EMPLEADO_ROL FOREIGN KEY (IDROL) REFERENCES dbo.ROL(IDROL)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go



CREATE TABLE dbo.TIPOREVISION
( 
	IDTIPOREVISION       integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	PRECIO               numeric(10,2)  NOT NULL ,
	CONSTRAINT XPKTIPOREVISION PRIMARY KEY (IDTIPOREVISION ASC)
)
go



CREATE TABLE dbo.CLIENTE
( 
	IDCLIENTE            integer IDENTITY ( 1,1 ) ,
	NOMBRE               varchar(100)  NOT NULL ,
	APELLIDO             varchar(100)  NOT NULL ,
	DNI                  varchar(20)  NOT NULL ,
	TELEFONO             varchar(20)  NOT NULL ,
	CORREO               varchar(100)  NOT NULL ,
	CONSTRAINT XPKCLIENTE PRIMARY KEY (IDCLIENTE ASC)
)
go



CREATE TABLE dbo.MARCA
( 
	IDMARCA              integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	CONSTRAINT XPKMARCA PRIMARY KEY (IDMARCA ASC)
)
go



CREATE TABLE dbo.AUTO
( 
	IDAUTO               integer IDENTITY ( 1,1 ) ,
	MATRICULA            varchar(20)  NOT NULL ,
	IDMARCA              integer  NOT NULL ,
	MODELO               varchar(20)  NOT NULL ,
	PRECIO               numeric(10,2)  NOT NULL ,
	COLOR                varchar(20)  NOT NULL ,
	VENDIDO              integer  NOT NULL ,
	CONSTRAINT XPKAUTO PRIMARY KEY (IDAUTO ASC),
	CONSTRAINT U_AUTO_MATRICULA UNIQUE (MATRICULA  ASC),
	CONSTRAINT FK_AUTO_MARCA FOREIGN KEY (IDMARCA) REFERENCES dbo.MARCA(IDMARCA)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
)
go


