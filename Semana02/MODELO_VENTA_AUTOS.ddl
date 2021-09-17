
CREATE TABLE AUTO
( 
	IDAUTO               integer  NOT NULL ,
	MATRICULA            varchar(20)  NOT NULL ,
	IDMARCA              integer  NOT NULL ,
	MODELO               varchar(20)  NOT NULL ,
	COLOR                varchar(20)  NOT NULL ,
	VENDIDO              integer  NOT NULL ,
	CONSTRAINT XPKAUTO PRIMARY KEY (IDAUTO ASC)
)
go



CREATE TABLE CLIENTE
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



CREATE TABLE DETALLEREVISION
( 
	IDTIPOREVISION       integer  NOT NULL ,
	IDREVISION           integer  NOT NULL ,
	PRECIO               numeric(10,2)  NOT NULL ,
	CANTIDAD             numeric(4)  NOT NULL ,
	SUBTOTAL             numeric(10,2)  NOT NULL ,
	COMENTARIO           varchar(1000)  NOT NULL ,
	CONSTRAINT XPKDETALLEREVISION PRIMARY KEY (IDTIPOREVISION ASC,IDREVISION ASC)
)
go



CREATE TABLE EMPLEADO
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
	CONSTRAINT XPKEMPLEADO PRIMARY KEY (IDEMPLEADO ASC)
)
go



CREATE TABLE MARCA
( 
	IDMARCA              integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	CONSTRAINT XPKMARCA PRIMARY KEY (IDMARCA ASC)
)
go



CREATE TABLE REVISION
( 
	IDREVISION           integer IDENTITY ( 1,1 ) ,
	IDAUTO               integer  NOT NULL ,
	IDEMPLEADO           integer  NULL ,
	FECHA                datetime  NOT NULL ,
	IMPORTE              numeric(12,2)  NOT NULL ,
	IMPUESTO             numeric(12,2)  NOT NULL ,
	TOTAL                numeric(12,2)  NOT NULL ,
	CONSTRAINT XPKREVISION PRIMARY KEY (IDREVISION ASC)
)
go



CREATE TABLE ROL
( 
	IDROL                integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	CONSTRAINT XPKROL PRIMARY KEY (IDROL ASC)
)
go



CREATE TABLE TIPOREVISION
( 
	IDTIPOREVISION       integer  NOT NULL ,
	NOMBRE               varchar(100)  NOT NULL ,
	PRECIO               numeric(10,2)  NOT NULL ,
	CONSTRAINT XPKTIPOREVISION PRIMARY KEY (IDTIPOREVISION ASC)
)
go



CREATE TABLE VENTA
( 
	IDVENTA              integer IDENTITY ( 1,1 ) ,
	IDCLIENTE            integer  NOT NULL ,
	IDEMPLEADO           integer  NOT NULL ,
	IDAUTO               integer  NOT NULL ,
	FECHA                datetime  NULL ,
	PRECIO               numeric(10,2)  NOT NULL ,
	CONSTRAINT XPKVENTA PRIMARY KEY (IDVENTA ASC)
)
go




ALTER TABLE AUTO
	ADD CONSTRAINT FK_AUTO_MARCA FOREIGN KEY (IDMARCA) REFERENCES MARCA(IDMARCA)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE DETALLEREVISION
	ADD CONSTRAINT FK_DETALLEREVISION_TIPO_REVISION FOREIGN KEY (IDTIPOREVISION) REFERENCES TIPOREVISION(IDTIPOREVISION)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE DETALLEREVISION
	ADD CONSTRAINT FK_DETALLE_REVISION FOREIGN KEY (IDREVISION) REFERENCES REVISION(IDREVISION)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE EMPLEADO
	ADD CONSTRAINT FK_EMPLEADO_ROL FOREIGN KEY (IDROL) REFERENCES ROL(IDROL)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE REVISION
	ADD CONSTRAINT FK_REVISION_AUTO FOREIGN KEY (IDAUTO) REFERENCES AUTO(IDAUTO)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE REVISION
	ADD CONSTRAINT FK_REVISION_EMPLEADO FOREIGN KEY (IDEMPLEADO) REFERENCES EMPLEADO(IDEMPLEADO)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE VENTA
	ADD CONSTRAINT FK_VENTA_CLIENTE FOREIGN KEY (IDCLIENTE) REFERENCES CLIENTE(IDCLIENTE)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE VENTA
	ADD CONSTRAINT FK_VENTA_EMPLEADO FOREIGN KEY (IDAUTO) REFERENCES AUTO(IDAUTO)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE VENTA
	ADD CONSTRAINT FK_VENTA_EMPLEADO FOREIGN KEY (IDEMPLEADO) REFERENCES EMPLEADO(IDEMPLEADO)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go

