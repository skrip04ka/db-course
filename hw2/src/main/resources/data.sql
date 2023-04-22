insert into groups (number) values
    ('E-10m-22'),
    ('E-11m-22'),
    ('E-12m-22'),
    ('E-13m-21');

insert into courses (name) values
    ('Mathematics'),
    ('Database management systems'),
    ('Algorithms'),
    ('Intelligent protection systems');

insert into courses_year (group_id, course_id, year_admission) values
    (select GROUPS.ID from GROUPS
        where GROUPS.NUMBER like 'E-10m-22',
    select COURSES.ID from COURSES
        where COURSES.NAME like 'Mathematics', '2022'),
    (select GROUPS.ID from GROUPS
        where GROUPS.NUMBER like 'E-12m-22',
     select COURSES.ID from COURSES
        where COURSES.NAME like 'Mathematics', '2022'),
    (select GROUPS.ID from GROUPS
     where GROUPS.NUMBER like 'E-13m-21',
     select COURSES.ID from COURSES
     where COURSES.NAME like 'Database management systems', '2021'),
    (select GROUPS.ID from GROUPS
        where GROUPS.NUMBER like 'E-13m-21',
     select COURSES.ID from COURSES
        where COURSES.NAME like 'Intelligent protection systems', '2021');

insert into students (name, group_id) values
    ('IvanovII', select GROUPS.ID from GROUPS
        where GROUPS.NUMBER like 'E-10m-22'),
    ('PetrovAV', select GROUPS.ID from GROUPS
        where GROUPS.NUMBER = 'E-10m-22'),
    ('SidorovBA', select GROUPS.ID from GROUPS
        where GROUPS.NUMBER like 'E-12m-22'),
    ('ArhipovSI', select GROUPS.ID from GROUPS
        where GROUPS.NUMBER like 'E-13m-21'),
    ('PopovDA', select GROUPS.ID from GROUPS
        where GROUPS.NUMBER like 'E-13m-21');

insert into scores (student_id, course_id, score) values
   (select STUDENTS.ID from STUDENTS
        where STUDENTS.NAME like 'IvanovII',
    select COURSES.ID from COURSES
        where COURSES.NAME like 'Mathematics', 5),
   (select STUDENTS.ID from STUDENTS
        where STUDENTS.NAME like 'PetrovAV',
    select COURSES.ID from COURSES
        where COURSES.NAME like 'Mathematics', 3),
   (select STUDENTS.ID from STUDENTS
        where STUDENTS.NAME like 'SidorovBA',
    select COURSES.ID from COURSES
        where COURSES.NAME like 'Mathematics', 3),
   (select STUDENTS.ID from STUDENTS
        where STUDENTS.NAME like 'ArhipovSI',
    select COURSES.ID from COURSES
        where COURSES.NAME like 'Database management systems', 4),
   (select STUDENTS.ID from STUDENTS
        where STUDENTS.NAME like 'ArhipovSI',
    select COURSES.ID from COURSES
        where COURSES.NAME like 'Intelligent protection systems', 5),
   (select STUDENTS.ID from STUDENTS
        where STUDENTS.NAME like 'PopovDA',
    select COURSES.ID from COURSES
        where COURSES.NAME like 'Intelligent protection systems', 3),
    (select STUDENTS.ID from STUDENTS
        where STUDENTS.NAME like 'PopovDA',
     select COURSES.ID from COURSES
        where COURSES.NAME like 'Database management systems', 3);