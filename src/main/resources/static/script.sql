CREATE DATABASE shoppingcartdb;

insert into USERS(email,password,address,phone,user_name,cart_id) 
values('employee@mindtree.com','abc123','Street A,India','8077456789','John',NULL);

insert into PRODUCTS(id,name,price,category,cart_id,quantity,brand,design,type,genre,author,publications) values(101,'Mrutyunjay',250.00,'Book',NULL, NULL, NULL,NULL,NULL,'Indian Writings','Shivaji Savant','Bhartiya');
insert into PRODUCTS(id,name,price,category,cart_id,quantity,brand,design,type,genre,author,publications) values(102,'Nagas',200.00,'Book',NULL, NULL,NULL,NULL,NULL,'Shiva','Amish Tripathi','Kindle');
insert into PRODUCTS(id,name,price,category,cart_id,quantity,brand,design,type,genre,author,publications) values(103,'Tshirt',450.00,'Apparel',NULL, NULL,'Puma','CollarT','Plain',NULL,NULL,NULL);
insert into PRODUCTS(id,name,price,category,cart_id,quantity,brand,design,type,genre,author,publications) values(104,'Skirt',500.00,'Apparel',NULL, NULL,'Kalakriti','Long','Printed',NULL,NULL,NULL);
