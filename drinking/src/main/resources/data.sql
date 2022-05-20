insert into restaurant (name, city) values ('Restoran 1', 'NS');


insert into drink (name, alcoholic, hot, caffeine, texture, restaurant_id) values ('Zajecarsko pivo', true, false, false, 0, 1);
insert into drink_ingredients (drink_id, ingredient) values (1, 'Voda');
insert into drink_ingredients (drink_id, ingredient) values (1, 'JECMENI slad');
insert into drink_ingredients (drink_id, ingredient) values (1, 'Hmelj');
insert into drink_ingredients (drink_id, ingredient) values (1, 'Ekstrakt hmelja');

insert into drink_tastes (drink_id, taste, value) values (1, 4, 6);
insert into drink_tastes (drink_id, taste, value) values (1, 3, 5);

insert into user (username, password, city) values ('markuza', 'markuza', 'NS');

insert into answer (text, answer_number, question) values ('Hot', 0, 'Do you like hot or cold drinks?');
insert into answer (text, answer_number, question) values ('Cold', 1, 'Do you like hot or cold drinks?');