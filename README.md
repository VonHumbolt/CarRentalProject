# Car Rental Project
Written by Java - Spring Boot. 

## Brief
Car Rental Project is a web site for renting a car. This web site consists of a home page, listed cars page, cars details page, login, register
and rent page. Home page is a entry view of site. In this page, users can viewed other customer's most preferred cars, they can obtain information about web site.
Also, they can create an account quickly. Listed cars page where the all cars are listed with pagination. In this page, users can filter cars by specific features.
Such as, car name, empty days, their companies, car types and prices. 
Users can go to the detail page of the car they choose by clicking on it. On the Car Detail Page, all the features of the car are displayed. 

## Technologies and Architecture
N-layered architecture was used as the software architecture of the project. The main layers of the project: Business, Controllers, Data Access, Entity, Core.
In this project, Spring Security, Spring Data Jpa, PostgreSql, Spring Web, Validation, Lombok and Thymeleaf technologies are used.
Authentication and authorization processes in the security process are provided with JWT. PostgreSql is used as a database. 
For the frontend of project, Thymeleaf is used. 

## UML Class Diagram of Entities
<p text-align="center"> 
	<img src="images/car_rental_entity.jpeg" />
</p>