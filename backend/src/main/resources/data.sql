INSERT INTO product(id, name, category, price, bitcoin, ethereum) VALUES('1','Iphone', 'phone','1000', '0','0');
INSERT INTO product(id, name, category, price, bitcoin, ethereum) VALUES('2','Samsung', 'phone','500', '0','0');
INSERT INTO product(id, name, category, price, bitcoin, ethereum) VALUES('3','Asus', 'pc','700','0','0');


INSERT INTO account(id, email, name, password) VALUES('1','john@example.com','John','test');
INSERT INTO account(id, email, name, password) VALUES('2','joe@example.com','Joe','test');
INSERT INTO account(id, email, name, password) VALUES('3','jack@example.com','Jack','test');  

INSERT INTO favorite(accountid, productid) VALUES('3','1');
INSERT INTO favorite(accountid, productid) VALUES('3','2');  
INSERT INTO favorite(accountid, productid) VALUES('3','3');  
INSERT INTO favorite(accountid, productid) VALUES('2','2');  
INSERT INTO favorite(accountid, productid) VALUES('2','3');  