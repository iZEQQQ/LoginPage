CREATE TABLE auction
(
    id            BIGINT        NOT NULL,
    title         VARCHAR       NOT NULL,
    description   VARCHAR       NOT NULL,
    price         NUMERIC(9, 2) NOT NULL,

    -- moje aukcje

    PRIMARY KEY (id),
    FOREIGN KEY (parameters_id) REFERENCES parameters (id)--,
 --   FOREIGN KEY (photos_id) REFERENCES photos (id)
);


CREATE TABLE parameter
(
    id BIGINT NOT NULL
-- nazwa
);

-- brakuje tabeli laczacej parametr z wartoscia w aukcji


CREATE TABLE photo
(
    -- brakuje id
  link VARCHAR NOT NULL,
    auction_id BIGINT NOT NULL,
    PRIMARY KEY(auction_id),-- blad!!!
        FOREIGN KEY (auction_id) REFERENCES auction (id)
);

CREATE TABLE branches -- liczba pojedyncza
(
    id          BIGINT  NOT NULL,
    branch      VARCHAR NOT NULL, -- nazwa!
    category_id BIGINT  NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE categories
(
    id         BIGINT  NOT NULL,
    category   VARCHAR NOT NULL,
    auction_id BIGINT  NOT NULL,
    FOREIGN KEY (auction_id) REFERENCES auction (id)

);