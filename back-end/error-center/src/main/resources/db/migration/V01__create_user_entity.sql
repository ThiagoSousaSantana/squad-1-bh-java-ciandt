CREATE TABLE "user"
(
    id       UUID         NOT NULL PRIMARY KEY,
    email    VARCHAR(150) NOT NULL,
    password VARCHAR(100) NOT NULL,
    token    VARCHAR(255) NOT NULL
);
