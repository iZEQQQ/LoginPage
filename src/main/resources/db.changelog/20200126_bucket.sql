CREATE TABLE bucket_elements
(
    userid    VARCHAR,
    auctionid INT,
    id        SERIAL,
    added     DATE,
    count     INT,
    PRIMARY KEY (id),
    FOREIGN KEY (userid) REFERENCES users (login),
    FOREIGN KEY (auctionid) REFERENCES auction (id)
);