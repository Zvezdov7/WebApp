DROP TABLE IF EXISTS cards;
CREATE TABLE cards (
  id            INTEGER auto_increment PRIMARY KEY,
  word          VARCHAR(256),
  description   VARCHAR(256),
  grade         INTEGER
);