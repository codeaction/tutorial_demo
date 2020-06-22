DROP DATABASE IF EXISTS ssm;
CREATE DATABASE ssm;
USE ssm;


DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(40) DEFAULT NULL,
  money float DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

INSERT INTO account VALUES ('1', 'Tom', '1999');
INSERT INTO account VALUES ('2', 'Bob', '2000');
INSERT INTO account VALUES ('3', 'Peter', '10000');
INSERT INTO account VALUES ('5', 'John', '9700');
INSERT INTO account VALUES ('6', 'Smith', '421315');
INSERT INTO account VALUES ('7', 'Rose', '8800000');
