-- Schema definition for the Registro Elettronico application

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE parent_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    card_id VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE student_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    card_id VARCHAR(255) NOT NULL UNIQUE,
    parent_id BIGINT,
    FOREIGN KEY (parent_id) REFERENCES parent_info(id)
);

CREATE TABLE teacher_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    card_id VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE secretary_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    card_id VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE class (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    year_start INT,
    year_end INT
);

CREATE TABLE student_class (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT NOT NULL,
    class_id BIGINT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student_info(id),
    FOREIGN KEY (class_id) REFERENCES class(id)
);

CREATE TABLE subject (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE subject_class (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    subject_id BIGINT NOT NULL,
    class_id BIGINT NOT NULL,
    teacher_id BIGINT NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subject(id),
    FOREIGN KEY (class_id) REFERENCES class(id),
    FOREIGN KEY (teacher_id) REFERENCES teacher_info(id)
);

CREATE TABLE subject_schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    day VARCHAR(20),
    hour_start TIME,
    hour_end TIME,
    subject_class_id BIGINT NOT NULL,
    frequency VARCHAR(20),
    FOREIGN KEY (subject_class_id) REFERENCES subject_class(id)
);

CREATE TABLE day_event (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    class_id BIGINT NOT NULL,
    FOREIGN KEY (class_id) REFERENCES class(id)
);

CREATE TABLE lesson_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    subject_class_id BIGINT NOT NULL,
    message TEXT,
    day_event_id BIGINT NOT NULL,
    created_at TIMESTAMP,
    FOREIGN KEY (subject_class_id) REFERENCES subject_class(id),
    FOREIGN KEY (day_event_id) REFERENCES day_event(id)
);

CREATE TABLE test (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    subject_class_id BIGINT NOT NULL,
    type VARCHAR(50),
    day_event_id BIGINT NOT NULL,
    FOREIGN KEY (subject_class_id) REFERENCES subject_class(id),
    FOREIGN KEY (day_event_id) REFERENCES day_event(id)
);

CREATE TABLE homework (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    subject_class_id BIGINT NOT NULL,
    message TEXT,
    deadline DATE,
    day_event_id BIGINT,
    FOREIGN KEY (subject_class_id) REFERENCES subject_class(id),
    FOREIGN KEY (day_event_id) REFERENCES day_event(id)
);

CREATE TABLE vote_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    vote DOUBLE,
    date DATE,
    student_class_id BIGINT NOT NULL,
    subject_class_id BIGINT NOT NULL,
    FOREIGN KEY (student_class_id) REFERENCES student_class(id),
    FOREIGN KEY (subject_class_id) REFERENCES subject_class(id)
);

CREATE TABLE scrutinio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(20),
    date DATE,
    vote DOUBLE,
    student_class_id BIGINT NOT NULL,
    FOREIGN KEY (student_class_id) REFERENCES student_class(id)
);

CREATE TABLE presence_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(20),
    date DATE,
    student_class_id BIGINT NOT NULL,
    FOREIGN KEY (student_class_id) REFERENCES student_class(id)
);

CREATE TABLE justification (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT NOT NULL,
    message TEXT,
    created_at TIMESTAMP,
    presence_record_id BIGINT NOT NULL,
    FOREIGN KEY (parent_id) REFERENCES parent_info(id),
    FOREIGN KEY (presence_record_id) REFERENCES presence_record(id)
);

CREATE TABLE reprimand (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_class_id BIGINT NOT NULL,
    title VARCHAR(255),
    message TEXT,
    subject_class_id BIGINT NOT NULL,
    created_at TIMESTAMP,
    FOREIGN KEY (student_class_id) REFERENCES student_class(id),
    FOREIGN KEY (subject_class_id) REFERENCES subject_class(id)
);

CREATE TABLE meeting (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT NOT NULL,
    subject_class_id BIGINT NOT NULL,
    status VARCHAR(20),
    due_date DATE,
    FOREIGN KEY (parent_id) REFERENCES parent_info(id),
    FOREIGN KEY (subject_class_id) REFERENCES subject_class(id)
);