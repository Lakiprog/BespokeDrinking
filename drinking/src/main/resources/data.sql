insert into restaurant (name, city) values ('Restoran 1', 'NS');
insert into restaurant (name, city) values ('Restoran 2', 'BG');


insert into drink (name, alcoholic, hot, caffeine, texture, restaurant_id) values ('Zajecarsko pivo', true, false, false, 0, 1);
insert into drink (name, alcoholic, hot, caffeine, texture, restaurant_id) values ('Gin tonic with lemon', true, false, false, 0, 1);
insert into drink (name, alcoholic, hot, caffeine, texture, restaurant_id) values ('Coffee', false, true, true, 0, 1);
insert into drink (name, alcoholic, hot, caffeine, texture, restaurant_id) values ('Coffee with chocolate', false, true, true, 0, 1);

insert into drink (name, alcoholic, hot, caffeine, texture, restaurant_id) values ('Zajecarsko pivo', true, false, false, 0, 2);
insert into drink (name, alcoholic, hot, caffeine, texture, restaurant_id) values ('Gin tonic with lemon', true, false, false, 0, 2);

insert into drink_ingredients (drink_id, ingredient) values (1, 'Voda');
insert into drink_ingredients (drink_id, ingredient) values (1, 'JECMENI slad');
insert into drink_ingredients (drink_id, ingredient) values (1, 'Hmelj');
insert into drink_ingredients (drink_id, ingredient) values (2, 'Gin');
insert into drink_ingredients (drink_id, ingredient) values (2, 'Tonic water');
insert into drink_ingredients (drink_id, ingredient) values (2, 'Lemon');

insert into drink_ingredients (drink_id, ingredient) values (5, 'Voda');
insert into drink_ingredients (drink_id, ingredient) values (5, 'JECMENI slad');
insert into drink_ingredients (drink_id, ingredient) values (5, 'Hmelj');
insert into drink_ingredients (drink_id, ingredient) values (6, 'Gin');
insert into drink_ingredients (drink_id, ingredient) values (6, 'Tonic water');
insert into drink_ingredients (drink_id, ingredient) values (6, 'Lemon');


insert into drink_tastes (drink_id, taste, value) values (1, 0, 0.0);
insert into drink_tastes (drink_id, taste, value) values (1, 1, 0.0);
insert into drink_tastes (drink_id, taste, value) values (1, 2, 0.0);
insert into drink_tastes (drink_id, taste, value) values (1, 3, 5.0);
insert into drink_tastes (drink_id, taste, value) values (1, 4, 6.0);
insert into drink_tastes (drink_id, taste, value) values (2, 0, 0.0);
insert into drink_tastes (drink_id, taste, value) values (2, 1, 0.0);
insert into drink_tastes (drink_id, taste, value) values (2, 2, 0.0);
insert into drink_tastes (drink_id, taste, value) values (2, 3, 3.0);
insert into drink_tastes (drink_id, taste, value) values (2, 4, 9.0);
insert into drink_tastes (drink_id, taste, value) values (3, 0, 4.0);
insert into drink_tastes (drink_id, taste, value) values (3, 1, 0.0);
insert into drink_tastes (drink_id, taste, value) values (3, 2, 0.0);
insert into drink_tastes (drink_id, taste, value) values (3, 3, 0.0);
insert into drink_tastes (drink_id, taste, value) values (3, 4, 0.0);
insert into drink_tastes (drink_id, taste, value) values (4, 0, 8.0);
insert into drink_tastes (drink_id, taste, value) values (4, 1, 0.0);
insert into drink_tastes (drink_id, taste, value) values (4, 2, 0.0);
insert into drink_tastes (drink_id, taste, value) values (4, 3, 0.0);
insert into drink_tastes (drink_id, taste, value) values (4, 4, 0.0);


insert into drink_tastes (drink_id, taste, value) values (5, 0, 0.0);
insert into drink_tastes (drink_id, taste, value) values (5, 1, 0.0);
insert into drink_tastes (drink_id, taste, value) values (5, 2, 0.0);
insert into drink_tastes (drink_id, taste, value) values (5, 3, 5.0);
insert into drink_tastes (drink_id, taste, value) values (5, 4, 6.0);
insert into drink_tastes (drink_id, taste, value) values (6, 0, 0.0);
insert into drink_tastes (drink_id, taste, value) values (6, 1, 0.0);
insert into drink_tastes (drink_id, taste, value) values (6, 2, 0.0);
insert into drink_tastes (drink_id, taste, value) values (6, 3, 3.0);
insert into drink_tastes (drink_id, taste, value) values (6, 4, 9.0);


insert into user (username, password, city, enabled) values ('markuza', '$2a$12$2OxIYBGYFdOFi6S96DNAGuZ.Rat9OigGXEjaN938snNryfdaefRba', 'NS', true);
insert into user (username, password, city, enabled) values ('petruza', '$2a$12$2OxIYBGYFdOFi6S96DNAGuZ.Rat9OigGXEjaN938snNryfdaefRba', 'NS', true);

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER');

insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (2, 2);

insert into question (text, created) values ('Are you 18?', false);
insert into question (text, created) values ('Do you like alcoholic drinks?', false);
insert into question (text, created) values ('Do you like drinks with caffeine?', false);
insert into question (text, created) values ('Do you like hot or cold drinks?', false);
insert into question (text, created) values ('What cold drink do you prefer?', false);
insert into question (text, created) values ('What alcoholic drink do you prefer?', false);
insert into question (text, created) values ('Do you drink coffee or tea more?', false);
insert into question (text, created) values ('How do you drink your coffee?', false);
insert into question (text, created) values ('How do you drink your tea?', false);
insert into question (text, created) values ('What kind of sweets do you prefer?', false);
insert into question (text, created) values ('What kind of ingredients do you prefer?', false);

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
insert into answer (text, answer_number) values ('Tea', 0);
insert into answer (text, answer_number) values ('Coffee', 1);
insert into answer (text, answer_number) values ('Bitter', 0);
insert into answer (text, answer_number) values ('Sweet', 1);
insert into answer (text, answer_number) values ('Bitter', 0);
insert into answer (text, answer_number) values ('Sweet', 1);
insert into answer (text, answer_number) values ('Candy', 0);
insert into answer (text, answer_number) values ('Ice cream', 1);
insert into answer (text, answer_number) values ('Chocolate', 2);
insert into answer (text, answer_number) values ('I do not like sweets', 3);
insert into answer (text, answer_number) values ('Lemon', 0);
insert into answer (text, answer_number) values ('Syrup', 1);
insert into answer (text, answer_number) values ('Coconut', 2);
insert into answer (text, answer_number) values ('Grapefruit', 3);

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
insert into question_answers (question_id, answers_id) values (9, 21);
insert into question_answers (question_id, answers_id) values (9, 22);
insert into question_answers (question_id, answers_id) values (10, 23);
insert into question_answers (question_id, answers_id) values (10, 24);
insert into question_answers (question_id, answers_id) values (10, 25);
insert into question_answers (question_id, answers_id) values (10, 26);
insert into question_answers (question_id, answers_id) values (11, 27);
insert into question_answers (question_id, answers_id) values (11, 28);
insert into question_answers (question_id, answers_id) values (11, 29);
insert into question_answers (question_id, answers_id) values (11, 30);