CREATE TABLE study_group (
                             id INT PRIMARY KEY,
                             name VARCHAR(32) NOT NULL
);

CREATE TABLE student (
                         id INT PRIMARY KEY,
                         name VARCHAR(64) NOT NULL,
                         surname VARCHAR(64) NOT NULL,
                         second_name VARCHAR(64) NOT NULL,
                         study_group_id INT,

                         FOREIGN KEY (study_group_id) REFERENCES study_group(id)
);



CREATE TABLE student_local (
                         id INT PRIMARY KEY,
                         name VARCHAR(64) NOT NULL,
                         surname VARCHAR(64) NOT NULL,
                         second_name VARCHAR(64) NOT NULL,
                         study_group_id INT,

                         FOREIGN KEY (study_group_id) REFERENCES study_group(id)
);



CREATE TABLE subject (
                         id INT PRIMARY KEY,
                         name VARCHAR(64) NOT NULL,
                         short_name VARCHAR(32) NOT NULL
);

CREATE TABLE exam_type (
                           id INT PRIMARY KEY,
                           type VARCHAR(128) NOT NULL
);

CREATE TABLE study_plan (
                            id INT PRIMARY KEY,
                            subject_id INT,
                            exam_type_id INT,

                            FOREIGN KEY (subject_id) REFERENCES subject(id),
                            FOREIGN KEY (exam_type_id) REFERENCES exam_type(id)
);

CREATE TABLE mark (
                      id INT PRIMARY KEY,
                      name VARCHAR(64) NOT NULL,
                      value VARCHAR(32) NOT NULL
);

CREATE TABLE journal (
                         id INT PRIMARY KEY,
                         student_id INT,
                         study_plan_id INT,
                         in_time BOOLEAN NOT NULL,
                         count INT NOT NULL,
                         mark_id INT,

                         FOREIGN KEY (student_id) REFERENCES student(id),
                         FOREIGN KEY (study_plan_id) REFERENCES study_plan(id),
                         FOREIGN KEY (mark_id) REFERENCES mark(id)

);


INSERT INTO subject VALUES (1, 'Проектирование информационных систем', 'ПрИС');
INSERT INTO subject VALUES (2, 'Системы искусственного интеллекта', 'СИИ');
INSERT INTO subject VALUES (3, 'Программная инженерия', 'ПИ');
INSERT INTO subject VALUES (4, 'Национальная система информационной безопасности', 'НСИБ');
INSERT INTO subject VALUES (5, 'Системный анализ', 'СисАнал');
INSERT INTO subject VALUES (6, 'Распределенные базы данных', 'РБД');
INSERT INTO subject VALUES (7, 'Системное программное обеспечение', 'СПО');


INSERT INTO exam_type VALUES (1, 'Экзамен');
INSERT INTO exam_type VALUES (2, 'Зачет');
INSERT INTO exam_type VALUES (3, 'Зачет с оценкой');
INSERT INTO exam_type VALUES (4, 'Курсовая');


INSERT INTO study_plan VALUES (1, 1, 1);
INSERT INTO study_plan VALUES (2, 1, 4);
INSERT INTO study_plan VALUES (3, 2, 1);
INSERT INTO study_plan VALUES (4, 3, 1);
INSERT INTO study_plan VALUES (5, 4, 2);
INSERT INTO study_plan VALUES (6, 5, 1);
INSERT INTO study_plan VALUES (7, 6, 2);
INSERT INTO study_plan VALUES (8, 7, 1);


INSERT INTO mark VALUES (1, 'Отлично', 5);
INSERT INTO mark VALUES (2, 'Хорошо', 4);
INSERT INTO mark VALUES (3, 'Удовлетворительно', 3);
INSERT INTO mark VALUES (4, 'Неудовлетворительно', 2);
INSERT INTO mark VALUES (5, 'Зачет', 'з');
INSERT INTO mark VALUES (6, 'Незачет', 'н');
INSERT INTO mark VALUES (7, 'Неявка', '');

INSERT INTO study_group VALUES (4, 'ИКБО-11-17');
INSERT INTO study_group VALUES (5, 'ИКБО-07-17');

-- INSERT INTO student_local VALUES (51, 'Артем', 'Малафеев', 'Евгеньевич', 4);
-- INSERT INTO student_local VALUES (52, 'Александр', 'Извеков', 'Вадимович', 5);
-- INSERT INTO student_local VALUES (53, 'fff', 'fff', 'fff', 5);
-- INSERT INTO student_local VALUES (54, 'aaa', 'aaa', 'aaa', 5);
INSERT INTO student_local VALUES (9799999, 'aaa', 'aaa', 'aaa', 5);