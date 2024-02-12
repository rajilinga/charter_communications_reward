CREATE TABLE CUSTOMER (CUSTOMER_ID int, CUSTOMER_NAME VARCHAR2(50) );
CREATE TABLE TRANSACTION (TRANSACTION_ID int,CUSTOMER_ID int ,TRANSACTION_DATE DATE,AMOUNT int);
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME) values (1001,'Customer1');
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME) values (1002,'Customer2');
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME) values (1003,'Customer3');
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (10001,1001,'2020-04-12',120);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (10002,1001,'2020-04-01',85);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (10003,1001,'2020-03-04',160);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (10004,1001,'2020-03-01',90);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (10005,1001,'2020-02-04',120);
COMMIT;