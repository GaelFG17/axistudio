---- Tabla de Area -----
CREATE TABLE area (
    id_area INT NOT NULL AUTO_INCREMENT,
    nombre_area VARCHAR(20) NOT NULL,
    descripcion_area VARCHAR(50) NOT NULL,
    estatus CHAR(1) DEFAULT '1',
    PRIMARY KEY(id_area)
);

---- Tabla de Area -----
CREATE TABLE rol (
    id_rol INT NOT NULL AUTO_INCREMENT,
    nombre_rol VARCHAR(20) NOT NULL,
    descripcion_rol VARCHAR(50) NOT NULL,
    estatus CHAR(1) DEFAULT '1',
    PRIMARY KEY(id_rol)
);


---- Tabla de Visitantes-----
CREATE TABLE visitantes(
    clv_Visitantes VARCHAR(5) NOT NULL,
    Nombre_v VARCHAR(15) NOT NULL,
    Ap1_v VARCHAR(15) NOT NULL,
    Ap2_v VARCHAR(15) NOT NULL,
    id_rol INT NOT NULL,
    id_area INT NOT NULL,
    estatus CHAR(1) DEFAULT '0',
    hora_entrada DATETIME DEFAULT CURRENT_TIMESTAMP,
    hora_salida DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_nombre VARCHAR(15) NOT NULL,
    contrasenia VARCHAR(32) NOT NULL,
    PRIMARY KEY(clv_Visitantes),
    FOREIGN KEY(id_rol) REFERENCES rol(id_rol),
    FOREIGN KEY(id_area) REFERENCES area(id_area)
);

---- Tabla de Empleados-----
CREATE TABLE empleados(
    clv_Empleados VARCHAR(15) NOT NULL,
    Nombre VARCHAR(15) NOT NULL,
    Ap1 VARCHAR(15) NOT NULL,
    Ap2 VARCHAR(15) NOT NULL,
    id_rol INT NOT NULL,
    id_area INT NOT NULL,
    estatus CHAR(1) DEFAULT '0',
    hora_entrada DATETIME DEFAULT CURRENT_TIMESTAMP,
    hora_salida DATETIME DEFAULT CURRENT_TIMESTAMP,
    email  VARCHAR(40) NOT NULL,
    password VARCHAR(90) NOT NULL,
    PRIMARY KEY(clv_Empleados),
    FOREIGN KEY(id_rol) REFERENCES rol(id_rol),
    FOREIGN KEY(id_area) REFERENCES area(id_area)
);