USE movies;

DROP TABLE IF EXISTS friend;

CREATE TABLE friend (
    lastname varchar(50),
    firstname varchar(50),
    movieid int
);

-- Inserting data using single quotes for string literals
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Haskell', 'Eddie', 3);
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Haskell', 'Eddie', 5);
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Cleaver', 'Wally', 9);
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Mondello', 'Lumpy', 2);
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Cleaver', 'Wally', 3);

-- Joining movie and friend tables to retrieve matching records
SELECT firstname, lastname, title 
FROM movie, friend 
WHERE movie.id = friend.movieid;

-- Selecting specific records based on lastname using single quotes
SELECT title FROM movie, friend
WHERE movie.id = friend.movieid
AND lastname = 'Haskell';

-- Select distinct first and last names from the friend table
SELECT DISTINCT lastname, firstname FROM friend;

-- Deleting a record from movie where id is 10
DELETE FROM movie WHERE id = 10;
SELECT * FROM movie;

-- Deleting records from friend table where lastname is 'Haskell'
DELETE FROM friend WHERE lastname = 'Haskell';
SELECT * FROM friend;

-- Updating price for a specific movie
UPDATE movie
SET price = 180.95
WHERE id = 8;

-- Updating friend's lastname and firstname
UPDATE friend 
SET lastname = 'Bully',
firstname = 'Big' 
WHERE firstname = 'Wally';

-- Increase the price of all movies by 10%
UPDATE movie 
SET price = price * 1.1;
SELECT * FROM movie;
