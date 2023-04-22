DROP TABLE IF EXISTS groups;
CREATE TABLE groups(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    number VARCHAR(255)
);

DROP TABLE IF EXISTS courses;
CREATE TABLE courses(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

DROP TABLE IF EXISTS student;
CREATE TABLE students(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    group_id BIGINT REFERENCES groups(id)
);

DROP TABLE IF EXISTS scores;
CREATE TABLE scores(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT REFERENCES students(id),
    course_id BIGINT REFERENCES courses(id),
    score INT
);

-- Вся группа полностью записана на курс
DROP TABLE IF EXISTS courses_year;
CREATE TABLE courses_year(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    group_id BIGINT REFERENCES groups(id),
    course_id BIGINT REFERENCES courses(id),
    year_admission VARCHAR(10)
);