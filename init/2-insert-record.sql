USE mydatabase;

INSERT INTO rol(descripcion_rol,estatus,nombre_rol) VALUES ('adminastrado', '1', 'ad');

INSERT INTO area (descripcion_area,estatus, nombre_area) VALUES ('Ejemplo','1', 'area pri');

INSERT INTO persona (clv_persona, apellido_materno, apellido_paterno, correo_electronico, curp, nombre_persona, rfc) VALUES ('12346', 'Franco', 'Garcia', 'ejemplo@gmail.com', 'AFGG', 'faafa', 'gswdvg');

INSERT INTO empleados(clv_Empleados, email, estatus, hora_entrada, hora_salida, password, id_area, clv_persona, id_rol) VALUES 
('00403', 'nfmgael@gmail.com', '1', '12:00:00', '14:00:00', '$2a$10$dFkmMsjxfuiTxlhMpdxIre9bRf/g2eu4LZMvo7H4ezrQrdFFXAxwa', '1', '12346', '1');