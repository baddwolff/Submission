drop database Exercises;

create database Exercises;

use Exercises;

create table Customers(
	customerId INT NOT NULL ,
	customerName VARCHAR(40) NULL,
	contactName VARCHAR(40) NOT NULL,
	country VARCHAR(40) NOT NULL,
	PRIMARY KEY( customerId )
);

INSERT INTO Customers (customerId,customerName,contactName,country)
VALUES (101,"Aditya","Aditya Girisha","India");

INSERT INTO Customers (customerId,customerName,contactName,country)
VALUES (102,"Ashish","Ashish Sanu","Portugal");

INSERT INTO Customers (customerId,customerName,contactName,country)
VALUES (103,"Sanjay","Sanjay Das","Nepal");

INSERT INTO Customers (customerId,customerName,contactName,country)
VALUES (104,"Satyam","Satyam Prakash","India");

INSERT INTO Customers (customerId,customerName,contactName,country)
VALUES (105,"Pavan","Pavan Bhosale","US");

INSERT INTO Customers (customerId,customerName,contactName,country)
VALUES (106,"Sreejit","Sreejit Menon","Sri Lanka");

create table Orders(
	orderId INT NOT NULL,
	customerId INT NOT NULL,
	orderDate DATE NOT NULL,
	PRIMARY KEY( orderId ),
	FOREIGN KEY (customerId) REFERENCES Customers(customerId)
);



INSERT INTO Orders (orderId,customerId,orderDate)
VALUES (202,102,'2010-11-10');

INSERT INTO Orders (orderId,customerId,orderDate)
VALUES (203,102,'2020-04-05');

INSERT INTO Orders (orderId,customerId,orderDate)
VALUES (204,103,'2012-12-19');

INSERT INTO Orders (orderId,customerId,orderDate)
VALUES (205,104,'2016-11-11');

INSERT INTO Orders (orderId,customerId,orderDate)
VALUES (206,105,'2007-1-1');

INSERT INTO Orders (orderId,customerId,orderDate)
VALUES (207,106,'2020-04-01');

INSERT INTO Orders (orderId,customerId,orderDate)
VALUES (208,106,'2018-09-11');

Select * from Orders;

Select * from Customers;

SELECT *
FROM Customers
LEFT JOIN Orders
ON Customers.customerId = Orders.customerId
GROUP BY customerName
ORDER BY orderDate;


SELECT *
FROM Customers
INNER JOIN Orders
ON Customers.customerId = Orders.customerId
GROUP BY customerName
ORDER BY orderDate ASC;

SELECT *
FROM Orders
RIGHT JOIN Customers
ON Customers.customerId = Orders.customerId
GROUP BY customerName
ORDER BY orderDate DESC;

SELECT Count(*),Max(orderDate),Min(customerName),Avg(orderId)
FROM Customers
INNER JOIN Orders
ON Customers.customerId = Orders.customerId;