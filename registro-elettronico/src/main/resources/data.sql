-- Utenti di base
INSERT INTO users (id, username, password) VALUES
(1, 'student1', 'password'),
(2, 'teacher1', 'password'),
(3, 'parent1', 'password');

-- Ruoli
INSERT INTO user_roles (user_id, role) VALUES
(1, 'STUDENT'),
(2, 'TEACHER'),
(3, 'PARENT');

-- Classi scolastiche
INSERT INTO school_class (id, name, section, school_year) VALUES
(1, '3A', 'A', 2024),
(2, '4B', 'B', 2025);

-- Studenti
INSERT INTO student_info (id, first_name, last_name, email, user_id, class_id) VALUES
(1, 'Mario', 'Rossi', 'mario.rossi@example.com', 1, 1);

-- Insegnanti
INSERT INTO teacher_info (id, first_name, last_name, email, user_id, subject) VALUES
(1, 'Lucia', 'Verdi', 'lucia.verdi@example.com', 2, 'Matematica');

-- Genitori
INSERT INTO parent_info (id, first_name, last_name, email, user_id, student_id) VALUES
(1, 'Giovanni', 'Rossi', 'giovanni.rossi@example.com', 3, 1);

-- Materie
INSERT INTO subject (id, name, teacher_id, class_id) VALUES
(1, 'Matematica', 1, 1);

-- Presenze
INSERT INTO presence_record (id, student_id, subject_id, date, present) VALUES
(1, 1, 1, '2025-09-15', TRUE),
(2, 1, 1, '2025-09-16', FALSE);
