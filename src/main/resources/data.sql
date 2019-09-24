insert into clinic values (1, 'montreal');

insert into patient values (1, 'John', 'Dupont');
insert into patient values (2, 'Robert', 'Ouellet');

insert into doctor values (1,'doctor', 'strange', 1);
insert into doctor values (2,'doctor', 'mackenzie', 1);

insert into time_slot values (1, '8:15', '8:00');
insert into time_slot values (2, '8:30', '8:15');
insert into time_slot values (3, '8:45', '8:30');
insert into time_slot values (4, '9:00', '8:45');
insert into time_slot values (5, '9:15', '9:00');
insert into time_slot values (6, '9:30', '9:15');
insert into time_slot values (7, '9:45', '9:30');
insert into time_slot values (8, '10:00', '9:45');
insert into time_slot values (9, '10:15', '10:00');
insert into time_slot values (10, '10:30', '10:15');
insert into time_slot values (11, '10:45', '10:30');
insert into time_slot values (12, '11:00', '10:45');
insert into time_slot values (13, '11:15', '11:00');
insert into time_slot values (14, '11:45', '11:30');
insert into time_slot values (15, '12:00', '11:45');

insert into appointment values (1, '2019-09-17', 1, null, 1);
insert into appointment values (2, '2019-09-17', 1, null, 2);
insert into appointment values (3, '2019-09-17', 1, 1, 3);
insert into appointment values (4, '2019-09-18', 1, null, 2);
insert into appointment values (5, '2019-09-19', 1, null, 3);
insert into appointment values (6, '2019-09-20', 1, null, 4);
insert into appointment values (7, '2019-09-21', 1, null, 5);

