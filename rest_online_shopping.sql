drop database if exists rest201;
create database rest201;
use rest201;

create table seller_product (
product_id int primary key not null,
product_name varchar(30) not null,
product_price varchar(10) not null,
product_category varchar(20) not null,
product_stock varchar(20),
product_description varchar(50));

create table buyer_product (
order_id int primary key not null, 
product_id int  not null,
product_name varchar(30) not null,
product_price varchar(10) not null,
product_category varchar(20) not null,
product_description varchar(50),
purchased_date varchar(20));

delimiter //
drop procedure if exists insert_product //
create procedure insert_product()
begin
Insert into seller_product (product_id, product_name, product_price,product_category,product_stock,product_description)
values('101','Moto g5 plus', '16000', 'Mobiles', '1', 'mobile phones');
Insert into seller_product (product_id, product_name, product_price,product_category,product_stock,product_description)
values('102','keyboard', '1000', 'Computer Accessories', '3', 'gaming keyborad');
Insert into seller_product (product_id, product_name, product_price,product_category,product_stock,product_description)
values('103','mouse', '700', 'Computer Accessories', '3', 'gaming mouse');
Insert into seller_product (product_id, product_name, product_price,product_category,product_stock,product_description)
values('104','Plastic bottle', '700', 'Kitchen', '10', 'high quality plastic water bottle');
end
//
delimiter ;
call insert_product();


delimiter //
drop procedure if exists insert_buyerproduct //
create procedure insert_buyerproduct()
begin
Insert into buyer_product (order_id,product_id, product_name, product_price,product_category,product_description,purchased_date)
values('1000','101','Moto g5 plus', '16000', 'Mobiles','mobile phones','03/11/2017 5:15 PM');

end
//
delimiter ;
call insert_buyerproduct();
