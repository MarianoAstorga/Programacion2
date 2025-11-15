-- Esquema actualizado según especificación
DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE biblioteca;

CREATE TABLE ficha_bibliografica (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  eliminado BOOLEAN NOT NULL DEFAULT FALSE,
  isbn VARCHAR(17) UNIQUE,
  clasificacion_dewey VARCHAR(20),
  estanteria VARCHAR(20),
  idioma VARCHAR(30)
);

CREATE TABLE libro (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  eliminado BOOLEAN NOT NULL DEFAULT FALSE,
  titulo VARCHAR(150) NOT NULL,
  autor VARCHAR(120) NOT NULL,
  editorial VARCHAR(100),
  anio_edicion INT,
  ficha_id BIGINT UNIQUE, -- 1:1 unidireccional A->B
  CONSTRAINT fk_libro_ficha FOREIGN KEY (ficha_id) REFERENCES ficha_bibliografica(id)
    ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE INDEX idx_libro_autor ON libro(autor);
CREATE INDEX idx_libro_titulo ON libro(titulo);
