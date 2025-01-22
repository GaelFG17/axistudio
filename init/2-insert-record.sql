USE mydatabase;

INSERT INTO rol(descripcion_rol,estatus,nombre_rol) VALUES ('adminastrado', '1', 'ad');

INSERT INTO area (descripcion_area,estatus, nombre_area) VALUES ('Ejemplo','1', 'Ventas');

INSERT INTO persona (clv_persona, apellido_materno, apellido_paterno, correo_electronico, curp, nombre_persona, rfc) VALUES ('12346', 'Franco', 'Garcia', 'ejemplo@gmail.com', 'AFGG', 'Gael', 'gswdvg');

INSERT INTO empleados(clv_Empleados, email, estatus, hora_entrada, hora_salida, password, id_area, clv_persona, id_rol) VALUES 
('00403', 'nfmgael@gmail.com', '1', '2025-01-15 12:00:00', '2025-01-15 14:00:00', '$2a$10$dFkmMsjxfuiTxlhMpdxIre9bRf/g2eu4LZMvo7H4ezrQrdFFXAxwa', '1', '12346', '1');

INSERT INTO persona (clv_persona, apellido_materno, apellido_paterno, correo_electronico, curp, nombre_persona, rfc) VALUES ('P453', 'Franco', 'Hernandez', 'ejemplo@gmail.com', 'AFGG', 'Juan', 'GH56');
INSERT INTO persona (clv_persona, apellido_materno, apellido_paterno, correo_electronico, curp, nombre_persona, rfc) VALUES ('P905', 'Garcia', 'Rodriguez', 'ejemplo@gmail.com', 'JSGDF', 'Miguel', 'FGR3');
INSERT INTO persona (clv_persona, apellido_materno, apellido_paterno, correo_electronico, curp, nombre_persona, rfc) VALUES ('P906', 'Sanchez', 'Hernandez', 'ejemplo@gmail.com', 'EDF', 'Julian', '90FGGH');
