CREATE TABLE LOGIN_LOG (
NAME VARCHAR(64),
IP VARCHAR(64),
LOGIN_DATE DATE
);
-------------------
CREATE TABLE LOGIN_LOG(
SEQ INTEGER GENERATED BY DEFAULT AS IDENTITY,
NAME VARCHAR(64),
IP VARCHAR(64),
LOGIN_DATE DATE
);
CREATE INDEX SEQidx ON LOGIN_LOG (SEQ);

------------------
DROP INDEX SEQIDX IF EXISTS;
DROP TABLE LOGIN_LOG IF EXISTS;
CREATE TABLE LOGIN_LOG(
SEQ INTEGER GENERATED BY DEFAULT AS IDENTITY,
NAME VARCHAR(64),
IP VARCHAR(64),
LOGIN_DATE DATE
);
CREATE INDEX SEQIdx ON LOGIN_LOG (SEQ);


----------INSERT----------
INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)
	VALUES('AAA','123.123.123','2014-02-04');
INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)
	VALUES('AAA','223.223.223','2014-02-05');
INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)
	VALUES('AAA','201.203.204','2014-02-06');

--INSERT INTO LOGIN_LOG (NAME,IP,LOGIN_DATE)	VALUES(?,?,?);

-----------SELECT------------
SELECT * FROM  LOGIN_LOG


