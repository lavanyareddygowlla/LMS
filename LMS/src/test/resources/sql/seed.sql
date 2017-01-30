use schooltest;
set FOREIGN_KEY_CHECKS = 0;
TRUNCATE table students;
TRUNCATE table klasses;
TRUNCATE table teachers;

set FOREIGN_KEY_CHECKS = 1;
insert into students (`email`)values('car@aol.com');

insert into teachers(`name`,`gender`,`age`)values ('lavanya','FEMALE',30),('t1',  'MALE',35),
  ('t2', 'FEMALE',21);

insert into klasses (credits, department, fee, name, semester, teacher_id) values
(4, 'SCIENCE', 500.0, 'Physics 101', '2017-01-25 00:00:00', 1),
(3, 'ENGINEERING', 550.0, 'Electrical Engineering 101', '2018-01-25 00:00:00', 2),
(2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00', 2);