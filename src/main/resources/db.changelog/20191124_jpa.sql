CREATE TABLE parameter
(
    id   SERIAL,
    name VARCHAR NOT NULL,

    PRIMARY KEY (id)

);

CREATE TABLE branch
(
    id   SERIAL,
    name VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE category
(
    id        SERIAL,
    name      VARCHAR NOT NULL,
    branch_id BIGINT  not null,
    PRIMARY KEY (id),
    FOREIGN KEY (branch_id) REFERENCES branch (id)

);

CREATE TABLE auction
(
    id          SERIAL,
    title       VARCHAR       NOT NULL,
    description VARCHAR       NOT NULL,
    price       NUMERIC(9, 2) NOT NULL,
    category_id BIGINT        not null,
    owner_id    VARCHAR       not null,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category (id),
    FOREIGN KEY (owner_id) REFERENCES users (login)
);

CREATE TABLE photo
(
    id         SERIAL,
    link       VARCHAR NOT NULL,
    auction_id BIGINT  NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (auction_id) REFERENCES auction (id)
);

CREATE TABLE auction_parameter
(
    id           SERIAL,
    number_value BIGINT,
    text_value   TEXT,
    auction_id   int not null,
    parameter_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (auction_id) REFERENCES auction (id),
    FOREIGN KEY (parameter_id) REFERENCES parameter (id)

);
