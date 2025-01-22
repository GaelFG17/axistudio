USE mydatabase;

INSERT INTO rol(descripcion_rol,estatus,nombre_rol) VALUES ('adminastrado', '1', 'ad');

INSERT INTO area (descripcion_area,estatus, nombre_area) VALUES ('Ejemplo','1', 'Ventas');

INSERT INTO empleados(clv_Empleados, Nombre, Ap1, Ap2, email, estatus, hora_entrada, hora_salida, password, id_area, id_rol) VALUES 
('00403', 'Gael', 'Franco', 'Garcia', 'nfmgael@gmail.com', '1', '2025-01-15 12:00:00', '2025-01-15 14:00:00', '$2a$10$dFkmMsjxfuiTxlhMpdxIre9bRf/g2eu4LZMvo7H4ezrQrdFFXAxwa', '1', '1');
