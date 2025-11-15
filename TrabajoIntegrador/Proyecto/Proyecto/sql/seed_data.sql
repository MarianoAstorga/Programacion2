USE biblioteca;

-- Fichas (B)
INSERT INTO ficha_bibliografica (eliminado, isbn, clasificacion_dewey, estanteria, idioma) VALUES
(false, '9780132350884', '005.1', 'A1', 'EN'),
(false, '9780134685991', '005.13', 'A2', 'EN'),
(false, '9780321127426', '005.3', 'A3', 'EN');

-- Libros (A) referenciando a Fichas
INSERT INTO libro (eliminado, titulo, autor, editorial, anio_edicion, ficha_id) VALUES
(false, 'Clean Code', 'Robert C. Martin', 'Prentice Hall', 2008, 1),
(false, 'Effective Java', 'Joshua Bloch', 'Addison-Wesley', 2018, 2),
(false, 'Patterns of Enterprise Application Architecture', 'Martin Fowler', 'Addison-Wesley', 2002, 3);
