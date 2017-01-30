use schooltest;

TRUNCATE table students;
TRUNCATE table klasses;
TRUNCATE table teachers;

insert into students (`email`)values('car@aol.com');

insert into teachers(`name`,`gender`,`age`)values ('lavanya','FEMALE',30);