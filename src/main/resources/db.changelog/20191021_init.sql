CREATE SEQUENCE hibernate_sequence;

CREATE TABLE users
(
    login  VARCHAR NOT NULL,
    pass  VARCHAR NOT NULL,
    name VARCHAR   NOT NULL,
    surname VARCHAR   NOT NULL,
    email  VARCHAR NOT NULL,
    checkPass  VARCHAR NOT NULL,
    loginLogin  VARCHAR,
    loginPass  VARCHAR,
    bday  DATE NOT NULL,

    PRIMARY KEY (login)
);