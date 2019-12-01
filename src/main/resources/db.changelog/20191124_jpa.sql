CREATE TABLE auction
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR       NOT NULL,
    description VARCHAR       NOT NULL,
    price       NUMERIC(9, 2) NOT NULL,
    category_id int           not null,
    user_id     int           not null,
    FOREIGN KEY (category_id) REFERENCES category (id),
    FOREIGN KEY (user_id) REFERENCES users (login)
);


CREATE TABLE parameter
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL

);

CREATE TABLE auction_parameter
(
    id           SERIAL PRIMARY KEY,
    number_value BIGINT,
    text_value   TEXT,
    auction_id   int not null,
    parameter_id int not null,
    FOREIGN KEY (auction_id) REFERENCES auction (id),
    FOREIGN KEY (parameter_id) REFERENCES parameter (id)

);


CREATE TABLE photo
(
    id         SERIAL PRIMARY KEY,
    link       VARCHAR NOT NULL,
    auction_id BIGINT  NOT NULL,
    FOREIGN KEY (auction_id) REFERENCES auction (id)
);

CREATE TABLE branch
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE category
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR NOT NULL,
    branch_id int     not null,
    FOREIGN KEY (branch_id) REFERENCES branch (id)

);