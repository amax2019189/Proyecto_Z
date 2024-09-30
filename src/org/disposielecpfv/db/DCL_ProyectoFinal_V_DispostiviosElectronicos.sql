-- CENTRO EDUCATIVO TECNICO LABORAL KINAL
-- CUARTO INFORMATICA  - IN4AM
-- CURSO DE TALLER
-- PROYECTO FINAL DEL AÑO 4TO 
-- Alumno: Juan Carlos Zeta Juárez
-- Clave # 31. Carnet: 2021001
-- Fecha: Guatemala, lunes 23 de septiembre de 2024.

-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS DispositivosElectronicosPFV;
USE DispositivosElectronicosPFV;

-- Creación de usuarios
CREATE USER 'AdminPFV2021001'@'localhost' IDENTIFIED BY 'Hola3600120'; 
CREATE USER 'DesarrolladorPFV2021001'@'localhost' IDENTIFIED BY 'Hola3600120';
CREATE USER 'DigitadorPFV2021001'@'localhost' IDENTIFIED BY 'Hola3600120';
CREATE USER 'ConsultorPFV2021001'@'localhost' IDENTIFIED BY 'Hola3600120';

-- Otorgar permisos a usuarios
-- Permisos para todas las bases de datos
GRANT ALL ON *.* TO 'AdminPFV2021001'@'localhost';

-- Permisos específicos para la base de datos DispositivosElectronicosPFV
GRANT ALL ON DispositivosElectronicosPFV.* TO 'AdminPFV2021001'@'localhost';
GRANT CREATE, DROP, ALTER, INSERT, SELECT ON DispositivosElectronicosPFV.* TO 'DesarrolladorPFV2021001'@'localhost';
GRANT INSERT, UPDATE, DELETE ON DispositivosElectronicosPFV.* TO 'DigitadorPFV2021001'@'localhost';
GRANT SELECT ON DispositivosElectronicosPFV.* TO 'ConsultorPFV2021001'@'localhost';

-- Aplicar cambios
FLUSH PRIVILEGES;
