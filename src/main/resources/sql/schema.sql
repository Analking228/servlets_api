DROP SCHEMA IF EXISTS cinema CASCADE;
CREATE SCHEMA IF NOT EXISTS cinema;

DROP TABLE IF EXISTS cinema.users;
DROP TABLE IF EXISTS cinema.logs;

CREATE TABLE IF NOT EXISTS cinema.users(
    user_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(100) NOT NULL,
    email   VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);
create table IF NOT EXISTS cinema.logs
(
    log_id SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL ,
    ip VARCHAR(100) NOT NULL,
    date timestamp not null default now()
);

