DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price INT NOT NULL
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    userid VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    houseid VARCHAR(50) NOT NULL,
    road VARCHAR(50) NOT NULL,
    province VARCHAR(50) NOT NULL,
    postid VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS cart;
CREATE TABLE cart (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    userid VARCHAR(50) NOT NULL,
    itemid INT NOT NULL
);