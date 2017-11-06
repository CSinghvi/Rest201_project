# Rest201_project

This is Online Shoping webapplication for restful web services 201 project.

-In this project sellers can add,update,view and delete the products they want to sell.
-Basic Authentication is used for Seller.
-Buyer can view the products sold by the seller and the products buyer purchased.
	Two filters are availbale for searching products.
		1.) Based on category of Products.
		2.) Price range of products.

(Note - In this project I have assumed only 1 seller and 1 buyer)

Technologies used :-
1.)Restful web services
2.)Springboot		
3.)Hibernate
4.)Gradle for buidling project and managing dependencies(instead of maven)

-To run the project should have gradle installed, and give this command
	"gradle bootrun"
	
-To build the project
	"gradle clean build"

-Using gradle 2.7 version

-Username and password for seller authentication is
	username = admin
	password = admin	
	
-Need to populate the database 
 Uploading .sql file("rest_online_shopping.sql") in the root folder of the project , please run it before running the applicaton.	


-If any issue please contact at "chirayu.singhvi@mindtree.com"

-githublink :- https://github.com/CSinghvi/Rest201_project 
	branch  :- Seller_RestApi