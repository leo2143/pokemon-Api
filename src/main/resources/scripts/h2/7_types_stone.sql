insert into type_stone values (1,'Piedra trueno');
insert into type_stone values (2,'Piedra fuego');
insert into type_stone values (3,'Piedra agua');
insert into type_stone values (4,'Piedra lunar');
insert into type_stone values (5,'Piedra hoja');
ALTER TABLE type_stone ALTER COLUMN type_stone_id RESTART WITH 6;
