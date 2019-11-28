CREATE TABLE auction
(
    id            BIGINT        NOT NULL,
    title         VARCHAR       NOT NULL,
    description   VARCHAR       NOT NULL,
    price         NUMERIC(9, 2) NOT NULL,
    parameters_id BIGINT        NOT NULL,
    photos_id     BIGINT        NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (parameters_id) REFERENCES parameters (id),
    FOREIGN KEY (photos_id) REFERENCES photos (id)
);


CREATE TABLE parameters
(
    id BIGINT NOT NULL
);


CREATE TABLE photos
(
    id BIGINT NOT NULL,
    photo_link VARCHAR NOT NULL
);

CREATE TABLE branches
(
    id BIGINT NOT NULL,
    branch VARCHAR NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE categories
(
    id BIGINT NOT NULL,
    category VARCHAR NOT NULL,
    auction_id BIGINT NOT NULL,
    FOREIGN KEY (auction_id) REFERENCES auction (id)

);