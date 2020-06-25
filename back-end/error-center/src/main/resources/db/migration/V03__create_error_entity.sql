CREATE TABLE error
(
    id          UUID         NOT NULL PRIMARY KEY,
    environment INTEGER      NOT NULL,
    level       INTEGER      NOT NULL,
    timestamp   TIMESTAMP    NOT NULL,
    title       VARCHAR(150) NOT NULL,
    details     VARCHAR(255) NOT NULL,
    origin_id   UUID         NOT NULL,
    user_id     UUID         NOT NULL,
    FOREIGN KEY (origin_id) REFERENCES origin (id),
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);
