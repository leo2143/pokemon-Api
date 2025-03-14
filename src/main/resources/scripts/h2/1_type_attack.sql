insert into type_attack(type_attack_id,name) values
 (1, 'Physical'),
 (2, 'Special');
ALTER TABLE type_attack ALTER COLUMN type_attack_id RESTART WITH 3;
