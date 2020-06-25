CREATE TABLE origin
(
    id      UUID         NOT NULL PRIMARY KEY,
    name    VARCHAR(150) NOT NULL,
    user_id UUID         NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);
