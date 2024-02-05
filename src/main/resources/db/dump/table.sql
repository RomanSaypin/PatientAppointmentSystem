CREATE TABLE doctors (
                         id BIGSERIAL NOT NULL PRIMARY KEY,
                         uuid UUID UNIQUE,
                         full_name VARCHAR(255),
                         specialization VARCHAR(255)
);

CREATE TABLE patients (
                          id BIGSERIAL NOT NULL PRIMARY KEY,
                          uuid UUID UNIQUE,
                          full_name VARCHAR(255),
                          date_of_birth DATE
);

CREATE TABLE time_slot (
                           id BIGSERIAL NOT NULL PRIMARY KEY,
                           doctor_id BIGSERIAL REFERENCES doctors(id),
                           patient_id BIGSERIAL REFERENCES patients(id),
                           start_time DATE
);

INSERT INTO doctors (uuid, full_name, specialization)
VALUES ('8e4b3b0d-13e8-4362-8c23-c4dfe61f6173', 'Иванов Иван Иванович', 'Терапевт'),
       ('33f4aae4-113b-4c7a-a35f-b5ab56fd34b7', 'Петров Петр Петрович', 'Хирург'),
       ('81c1e86f-876b-405e-87e0-9eb80b039c18', 'Сидорова Елена Петровна', 'Окулист');

-- Заполняем таблицу patients

INSERT INTO patients (uuid, full_name, date_of_birth)
VALUES ('823d6c1e-2142-4309-8e8d-bd1a99cbf38d', 'Смирнова Анна Сергеевна', '1990-05-10'),
       ('0aed6d5c-4471-4a71-8018-ed0ddf99255d', 'Ковалев Дмитрий Викторович', '1985-12-03'),
       ('8f5d6f26-6af3-45a4-b6e6-bb4bf54d853c', 'Мирошниченко Ольга Владимировна', '1978-07-25');

-- Заполняем таблицу time_slot

INSERT INTO time_slot (doctor_id, patient_id, start_time)
VALUES (1, 1, '20224-08-15 09:00:00'),
       (1, 2, '20224-08-15 10:00:00'),
       (2, 3, '2024-08-15 11:00:00');