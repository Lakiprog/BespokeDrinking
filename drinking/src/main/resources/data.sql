insert into restaurant (name, city) values ('Restoran 1', 'NS');


insert into drink (name, alcoholic, hot, caffeine, texture, restaurant_id) values ('Zajecarsko pivo', true, false, false, 0, 1);
insert into drink (name, alcoholic, hot, caffeine, texture, restaurant_id) values ('Gin tonic', true, false, false, 0, 1);
insert into drink_ingredients (drink_id, ingredient) values (1, 'Voda');
insert into drink_ingredients (drink_id, ingredient) values (1, 'JECMENI slad');
insert into drink_ingredients (drink_id, ingredient) values (1, 'Hmelj');
insert into drink_ingredients (drink_id, ingredient) values (2, 'Gin');
insert into drink_ingredients (drink_id, ingredient) values (2, 'Tonic water');

insert into drink_tastes (drink_id, taste, value) values (1, 4, 6.0);
insert into drink_tastes (drink_id, taste, value) values (1, 3, 5.0);
insert into drink_tastes (drink_id, taste, value) values (2, 4, 4.0);
insert into drink_tastes (drink_id, taste, value) values (2, 3, 3.0);

insert into user (username, password, city) values ('markuza', 'markuza', 'NS');

insert into question (text) values ('Are you 18?');
insert into question (text) values ('Do you like alcoholic drinks?');
insert into question (text) values ('Do you like drinks with caffeine?');
insert into question (text) values ('Do you like hot or cold drinks?');
insert into question (text) values ('What cold drink do you prefer?');
insert into question (text) values ('What alcoholic drink do you prefer?');
insert into question (text) values ('Do you drink coffee or tea more?');
insert into question (text) values ('How do you drink your coffee?');
insert into question (text) values ('How do you drink your tea?');

insert into answer (text, answer_number) values ('Below 18', 0);
insert into answer (text, answer_number) values ('Above 18', 1);
insert into answer (text, answer_number) values ('Without alcohol', 0);
insert into answer (text, answer_number) values ('With alcohol', 1);
insert into answer (text, answer_number) values ('No caffeine', 0);
insert into answer (text, answer_number) values ('Wtih caffeine', 1);
insert into answer (text, answer_number) values ('Hot', 0);
insert into answer (text, answer_number) values ('Cold', 1);
insert into answer (text, answer_number) values ('Milkshake', 0);
insert into answer (text, answer_number) values ('Squeezed fruit juice', 1);
insert into answer (text, answer_number) values ('Lemonade', 2);
insert into answer (text, answer_number) values ('Coca cola', 3);
insert into answer (text, answer_number) values ('Gin tonic', 0);
insert into answer (text, answer_number) values ('Mohito', 1);
insert into answer (text, answer_number) values ('Vine', 2);
insert into answer (text, answer_number) values ('Cocktail', 3);
insert into answer (text, answer_number) values ('Coffee', 0);
insert into answer (text, answer_number) values ('Tea', 1);
insert into answer (text, answer_number) values ('Bitter', 0);
insert into answer (text, answer_number) values ('Sweet', 1);

insert into question_answers (question_id, answers_id) values (1, 1);
insert into question_answers (question_id, answers_id) values (1, 2);
insert into question_answers (question_id, answers_id) values (2, 3);
insert into question_answers (question_id, answers_id) values (2, 4);
insert into question_answers (question_id, answers_id) values (3, 5);
insert into question_answers (question_id, answers_id) values (3, 6);
insert into question_answers (question_id, answers_id) values (4, 7);
insert into question_answers (question_id, answers_id) values (4, 8);
insert into question_answers (question_id, answers_id) values (5, 9);
insert into question_answers (question_id, answers_id) values (5, 10);
insert into question_answers (question_id, answers_id) values (5, 11);
insert into question_answers (question_id, answers_id) values (5, 12);
insert into question_answers (question_id, answers_id) values (6, 13);
insert into question_answers (question_id, answers_id) values (6, 14);
insert into question_answers (question_id, answers_id) values (6, 15);
insert into question_answers (question_id, answers_id) values (6, 16);
insert into question_answers (question_id, answers_id) values (7, 17);
insert into question_answers (question_id, answers_id) values (7, 18);
insert into question_answers (question_id, answers_id) values (8, 19);
insert into question_answers (question_id, answers_id) values (8, 20);