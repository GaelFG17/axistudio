CREATE TABLE persona(
    clv_persona VARCHAR(5) NOT NULL,
    nombre_persona VARCHAR(20) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NOT NULL,
    CURP VARCHAR(18) NOT NULL,
    RFC VARCHAR(13) NOT NULL,
    correo_electronico VARCHAR(20) NOT NULL,
    PRIMARY KEY(clv_persona)

);

---- Tabla de roles -----
CREATE TABLE rol (
    id_rol INT NOT NULL AUTO_INCREMENT,
    nombre_rol VARCHAR(20) NOT NULL,
    descripcion_rol VARCHAR(50) NOT NULL,
    estatus CHAR(1) DEFAULT '1',
    PRIMARY KEY(id_rol)
);

---- Tabla de Area -----
CREATE TABLE Area (
    id_area INT NOT NULL AUTO_INCREMENT,
    nombre_area VARCHAR(20) NOT NULL,
    descripcion_area VARCHAR(50) NOT NULL,
    estatus CHAR(1) DEFAULT '1',
    PRIMARY KEY(id_area)
);

---- Tabla de Visitantes-----
CREATE TABLE Visitantes(
    clv_Visitantes VARCHAR(5) NOT NULL,
    clv_persona VARCHAR(5) NOT NULL,
    id_rol INT NOT NULL,
    id_area INT NOT NULL,
    estatus CHAR(1) DEFAULT '0',
    hora_entrada DATETIME DEFAULT CURRENT_TIMESTAMP,
    hora_salida DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_nombre VARCHAR(15) NOT NULL,
    contrasenia VARCHAR(32) NOT NULL,
    PRIMARY KEY(clv_Visitantes),
    FOREIGN KEY(clv_persona) REFERENCES persona(clv_persona),
    FOREIGN KEY(id_rol) REFERENCES rol(id_rol),
    FOREIGN KEY(id_area) REFERENCES Area(id_area)
);

---- Tabla de Empleados-----
CREATE TABLE Empleados(
    clv_Empleados VARCHAR(5) NOT NULL,
    clv_persona VARCHAR(5) NOT NULL,
    id_rol INT NOT NULL,
    id_area INT NOT NULL,
    estatus CHAR(1) DEFAULT '0',
    hora_entrada DATETIME DEFAULT CURRENT_TIMESTAMP,
    hora_salida DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_nombre VARCHAR(15) NOT NULL,
    contrasenia VARCHAR(32) NOT NULL,
    PRIMARY KEY(clv_Empleados),
    FOREIGN KEY(clv_persona) REFERENCES persona(clv_persona),
    FOREIGN KEY(id_rol) REFERENCES rol(id_rol),
    FOREIGN KEY(id_area) REFERENCES Area(id_area)
);

