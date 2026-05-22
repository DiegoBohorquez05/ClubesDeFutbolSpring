-- Asociaciones
INSERT INTO asociaciones (nombre, pais, presidente) VALUES
    ('Premier League',        'Inglaterra', 'Richard Masters'),
    ('La Liga',               'Espana',     'Javier Tebas'),
    ('UEFA Champions League', 'Europa',     'Aleksander Ceferin');

-- Entrenadores
INSERT INTO entrenadores (nombre, apellido, edad, nacionalidad) VALUES
    ('Pep',    'Guardiola', 53, 'Espanol'),
    ('Carlo',  'Ancelotti', 65, 'Italiano'),
    ('Jurgen', 'Klopp',     57, 'Aleman');

-- Clubes
INSERT INTO clubes (nombre, ciudad, anio_fundacion, entrenador_id, asociacion_id) VALUES
    ('Manchester City', 'Manchester', 1880, 1, 1),
    ('Real Madrid',     'Madrid',     1902, 2, 2),
    ('Liverpool FC',    'Liverpool',  1892, 3, 1);

-- Jugadores
INSERT INTO jugadores (nombre, apellido, numero, posicion, id_club) VALUES
    ('Erling',   'Haaland',   9,  'Delantero',     1),
    ('Kevin',    'De Bruyne', 17, 'Mediocampista', 1),
    ('Phil',     'Foden',     47, 'Mediocampista', 1),
    ('Vinicius', 'Junior',    7,  'Delantero',     2),
    ('Luka',     'Modric',    10, 'Mediocampista', 2),
    ('Mohamed',  'Salah',     11, 'Delantero',     3);

-- Competiciones
INSERT INTO competiciones (nombre, monto_premio, fecha_inicio, fecha_fin) VALUES
    ('UEFA Champions League', 2000000000, '2025-09-17', '2026-05-31'),
    ('Premier League',        1500000000, '2025-08-16', '2026-05-24'),
    ('La Liga',               1200000000, '2025-08-15', '2026-05-17');

-- ManyToMany
INSERT INTO clubes_competiciones (club_id, competicion_id) VALUES
    (1, 1),(1, 2),
    (2, 1),(2, 3),
    (3, 1),(3, 2);
