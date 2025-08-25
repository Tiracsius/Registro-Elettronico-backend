CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS school_class (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    section VARCHAR(10),
    school_year INT
);

CREATE TABLE IF NOT EXISTS student_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    user_id BIGINT,
    class_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (class_id) REFERENCES school_class(id)
);

CREATE TABLE IF NOT EXISTS teacher_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    user_id BIGINT,
    subject VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS parent_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    user_id BIGINT,
    student_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (student_id) REFERENCES student_info(id)
);

CREATE TABLE IF NOT EXISTS subject (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    teacher_id BIGINT,
    class_id BIGINT,
    FOREIGN KEY (teacher_id) REFERENCES teacher_info(id),
    FOREIGN KEY (class_id) REFERENCES school_class(id)
);

CREATE TABLE IF NOT EXISTS presence_record (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT,
    subject_id BIGINT,
    date DATE,
    present BOOLEAN,
    FOREIGN KEY (student_id) REFERENCES student_info(id),
    FOREIGN KEY (subject_id) REFERENCES subject(id)
);
