-- CENTRO EDUCATIVO TECNICO LABORAL KINAL
-- CUARTO INFORMATICA  - IN4AM
-- CURSO DE TALLER
-- PROYECTO FINAL DEL AÑO 4TO 
-- Alumno: Juan Carlos Zeta Juárez
-- Clave # 31. Carnet: 2021001
-- Fecha: Guatemala, jueves 26 de septiembre de 2024.

-- Creación de la base de datos
DROP DATABASE IF EXISTS DispositivosElectronicosPFVtbl_usuario;
CREATE DATABASE IF NOT EXISTS DispositivosElectronicosPFV;
USE DispositivosElectronicosPFV;

-- Tabla: Genero
CREATE TABLE IF NOT EXISTS tbl_genero (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- Tabla: Persona
CREATE TABLE IF NOT EXISTS tbl_persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    id_genero INT,
    fecha_nacimiento DATE,
    email VARCHAR(100) UNIQUE,
    creado DATETIME NOT NULL DEFAULT NOW(),
    actualizado DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    FOREIGN KEY (id_genero) REFERENCES tbl_genero(id)
) ENGINE=InnoDB;

-- Tabla: Telefono
CREATE TABLE IF NOT EXISTS tbl_telefono (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(20) NOT NULL UNIQUE,
    tipo ENUM('Casa', 'Trabajo', 'Móvil') DEFAULT 'Móvil',
    id_persona INT,
    FOREIGN KEY (id_persona) REFERENCES tbl_persona(id)
) ENGINE=InnoDB;

-- Tabla: Rol
CREATE TABLE IF NOT EXISTS tbl_rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- Tabla: Usuario
CREATE TABLE IF NOT EXISTS tbl_usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_persona INT,
    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    id_rol INT,
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion DATETIME DEFAULT NOW(),
    creado DATETIME NOT NULL DEFAULT NOW(),
    actualizado DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    FOREIGN KEY (id_persona) REFERENCES tbl_persona(id),
    FOREIGN KEY (id_rol) REFERENCES tbl_rol(id)
) ENGINE=InnoDB;

-- Tabla: Categoria
CREATE TABLE IF NOT EXISTS Categoria (
    idCategoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(128) NOT NULL
) ENGINE=InnoDB;

-- Tabla: Producto
CREATE TABLE IF NOT EXISTS Producto (
    idProducto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombreProducto VARCHAR(128) NOT NULL,
    descripcionProducto VARCHAR(128),
    precioProducto DECIMAL(10,2) NOT NULL,
    idCategoria INT NOT NULL,
    CONSTRAINT FK_CATEGORIA_PRODUCTO FOREIGN KEY (idCategoria) REFERENCES Categoria(idCategoria)
) ENGINE=InnoDB;

-- Tabla: Caracteristica
CREATE TABLE IF NOT EXISTS Caracteristica (
    idCaracteristica INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pantalla VARCHAR(128) NOT NULL,
    procesador VARCHAR(128) NOT NULL,
    tamanio VARCHAR(128) NOT NULL,
    peso VARCHAR(128) NOT NULL,
    idProducto INT NOT NULL,
    CONSTRAINT FK_PRODUCTO_CARACTERISTICA FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
) ENGINE=InnoDB;

-- Procedimiento: sp_buscar_genero
DROP PROCEDURE IF EXISTS sp_buscar_genero;
DELIMITER //
CREATE PROCEDURE sp_buscar_genero()
BEGIN
    SELECT nombre FROM tbl_genero;
END //
DELIMITER ;

-- Procedimiento: sp_iniciar_sesion
DROP PROCEDURE IF EXISTS sp_iniciar_sesion;
DELIMITER //
CREATE PROCEDURE sp_iniciar_sesion (
    IN _usuario VARCHAR(128), 
    IN _contrasenia VARCHAR(128)
)
BEGIN
    SELECT tbl_usuario.id, tbl_usuario.nombre_usuario, tbl_rol.nombre AS rol, tbl_usuario.id_persona
    FROM tbl_usuario
    JOIN tbl_rol ON tbl_rol.id = tbl_usuario.id_rol
    WHERE tbl_usuario.nombre_usuario = _usuario 
    AND tbl_usuario.contrasena = MD5(_contrasenia)
    AND tbl_usuario.activo = TRUE;
END //
DELIMITER ;

-- Procedimiento: sp_buscar_email
DROP PROCEDURE IF EXISTS sp_buscar_email;
DELIMITER //
CREATE PROCEDURE sp_buscar_email (IN _email VARCHAR(128))
BEGIN	
    SELECT email
    FROM tbl_persona
    WHERE email = _email;
END //
DELIMITER ;

-- Función: fn_buscar_id_genero
DROP FUNCTION IF EXISTS fn_buscar_id_genero;
DELIMITER //
CREATE FUNCTION fn_buscar_id_genero(_genero VARCHAR(50)) RETURNS INT DETERMINISTIC
BEGIN
    DECLARE id_encontrado INT;
    SELECT id INTO id_encontrado
    FROM tbl_genero
    WHERE nombre = _genero;
    RETURN id_encontrado;
END //
DELIMITER ;

-- Función: fn_buscar_id_persona
DROP FUNCTION IF EXISTS fn_buscar_id_persona;
DELIMITER //
CREATE FUNCTION fn_buscar_id_persona(
    _nombre VARCHAR(100), 
    _apellido VARCHAR(100), 
    _fecha_nacimiento DATE, 
    _direccion VARCHAR(255), 
    _id_genero INT
) RETURNS INT DETERMINISTIC
BEGIN
    DECLARE id_encontrado INT;
    SELECT id INTO id_encontrado
    FROM tbl_persona
    WHERE nombre = _nombre 
    AND apellido = _apellido
    AND fecha_nacimiento = _fecha_nacimiento
    AND direccion = _direccion
    AND id_genero = _id_genero;
    RETURN id_encontrado;
END //
DELIMITER ;

-- Procedimiento: sp_insertar_usuario
DROP PROCEDURE IF EXISTS sp_insertar_usuario;
DELIMITER //
CREATE PROCEDURE sp_insertar_usuario(
    IN _nombre VARCHAR(100), 
    IN _apellido VARCHAR(100), 
    IN _genero VARCHAR(50), 
    IN _direccion VARCHAR(255), 
    IN _fecha_nacimiento DATE, 
    IN _usuario VARCHAR(32), 
    IN _contrasena VARCHAR(128), 
    IN _email VARCHAR(100), 
    IN _telefono VARCHAR(20)
)
BEGIN
    DECLARE var_id_genero INT;
    DECLARE var_id_persona INT;

    -- Buscar el ID del género
    SET var_id_genero = fn_buscar_id_genero(_genero);

    -- Insertar la persona
    INSERT INTO tbl_persona (nombre, apellido, fecha_nacimiento, direccion, id_genero, email)
    VALUES (_nombre, _apellido, _fecha_nacimiento, _direccion, var_id_genero, _email);

    -- Obtener el ID de la persona recién insertada
    SET var_id_persona = LAST_INSERT_ID();

    -- Insertar el teléfono
    INSERT INTO tbl_telefono (numero, id_persona)
    VALUES (_telefono, var_id_persona);

    -- Insertar el usuario con rol por defecto (id_rol = 1)
    INSERT INTO tbl_usuario (nombre_usuario, contrasena, id_persona, id_rol, activo, fecha_creacion)
    VALUES (_usuario, MD5(_contrasena), var_id_persona, 1, TRUE, NOW());

    -- Devolver el ID del usuario recién creado
    SELECT id AS id_usuario FROM tbl_usuario WHERE id_persona = var_id_persona;
END //
DELIMITER ;
