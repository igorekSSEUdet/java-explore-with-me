DROP TABLE IF EXISTS apps, requests CASCADE;

CREATE TABLE IF NOT EXISTS apps (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    name varchar(512) NOT NULL
);

CREATE TABLE IF NOT EXISTS requests (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    app_id BIGINT REFERENCES apps(id) ON DELETE CASCADE,
    uri varchar(512) NOT NULL,
    ip varchar(45) NOT NULL,
    time_stamp TIMESTAMP WITHOUT TIME ZONE
);