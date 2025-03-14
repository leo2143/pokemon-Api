insert into types(type_id,name,type_attack_id) values
(1, 'Water', 2),
(2, 'Bug', 1),
(3, 'Dragon', 2),
(4, 'Electric', 2),
(5, 'Ghost', 1),
(6, 'Fire', 2),
(7, 'Ice', 2),
(8, 'Fighting', 1),
(9, 'Normal', 1),
(10, 'Grass', 2),
(11, 'Psychic', 2),
(12, 'Rock', 1),
(13, 'Ground', 1),
(14, 'Poison', 1),
(15, 'Flying', 1);
ALTER TABLE types ALTER COLUMN type_id RESTART WITH 16;
