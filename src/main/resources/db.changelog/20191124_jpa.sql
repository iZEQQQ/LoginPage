CREATE TABLE auction
(
    id          BIGINT        NOT NULL,
    title       VARCHAR       NOT NULL,
    description VARCHAR       NOT NULL,
    price       NUMERIC(9, 2) NOT NULL,
    my_auctions VARCHAR       NOT NULL,

    PRIMARY KEY (id)

);


CREATE TABLE parameter
(
    id   BIGINT  NOT NULL,
    name VARCHAR NOT NULL
);

-- brakuje tabeli laczacej parametr z wartoscia w aukcji


CREATE TABLE photo
(
    id         BIGINT  NOT NULL,
    link       VARCHAR NOT NULL,
    auction_id BIGINT  NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (auction_id) REFERENCES auction (id)
);

CREATE TABLE branch
(
    id          BIGINT  NOT NULL,
    name        VARCHAR NOT NULL,
    category_id BIGINT  NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE category
(
    id         BIGINT  NOT NULL,
    name   VARCHAR NOT NULL,
    auction_id BIGINT  NOT NULL,
    FOREIGN KEY (auction_id) REFERENCES auction (id)

);