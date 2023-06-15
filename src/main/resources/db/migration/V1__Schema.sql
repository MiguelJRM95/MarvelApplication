CREATE TABLE IF NOT EXISTS character(
    id IDENTITY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    image_url VARCHAR(255),
    primary key(id)
);

CREATE TABLE IF NOT EXISTS comic(
    id IDENTITY,
    name VARCHAR(255) NOT NULL,
    primary key(id)
);