DROP DATABASE IF EXISTS springlearn;
CREATE DATABASE springlearn;
USE springlearn;


DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(40) DEFAULT NULL,
  money float DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

INSERT INTO account VALUES ('1', 'aaa', '1000');
INSERT INTO account VALUES ('2', 'bbb', '1000');
INSERT INTO account VALUES ('3', 'ccc', '1000');
INSERT INTO account VALUES ('5', 'cc', '10000');
INSERT INTO account VALUES ('6', 'abc', '10000');
INSERT INTO account VALUES ('7', 'abc', '10000');
