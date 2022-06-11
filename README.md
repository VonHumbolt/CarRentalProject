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
In this project, Spring Security, Spring Data Jpa, PostgreSql, Spring Web, Validation, Bootstrap, Lombok and Thymeleaf technologies are used.
Authentication and authorization processes in the security process are provided with JWT. PostgreSql is used as a database. 
For the frontend of project, Thymeleaf is used. 

## UML Class Diagram of Entities
<p text-align="center"> 
	<img src="images/car_rental_entity.jpeg" />
</p>

## Project's UI
Project's UI design was created using Bootstrap and Thymeleaf. It has a responsive design for tablets, phones.
<p text-align="center"> 
	<img src="images/index_lg.jpeg" />
	<img src="images/index_sm.jpeg" />
	 - 
	<img src="images/index_lg_2.jpeg" />
	<img src="images/index_sm_2.jpeg" />
</p>

### Home Page
Users can filter cars by rent and return date.
<p text-align="center"> 
	<img src="images/index_lg.jpeg" />
	<img src="images/index_lg_2.jpeg" />
	<img src="images/car_modal.jpeg" />
</p>

### Car List Page
All Cars lists in this page with pagination.
<p text-align="center"> 
	<img src="images/car_list_lg.jpeg" />
</p>

### Car Detail Page
Users can go to car detail page by clicking car image.
<p text-align="center"> 
	<img src="images/car_detail_lg.jpeg" />
	<img src="images/car_detail_sm.jpeg" />
</p>

### Registration Page
The registration form to create an account is on this page.
<p text-align="center"> 
	<img src="images/registration.jpeg" />
</p>

### Payment Messages
<p text-align="center"> 
	<img src="images/payment_success.jpeg" />
	<img src="images/payment_error.jpeg" />
</p>

## Layers of Project

### Entity
Entity classes which are represented in database as a table, dtos are in this package.

### Data Access
JpaRepository interfaces for accessing the database and retrieving the values are here.

### Core
Security classes and filters which are necessary for using Spring Security.

### Business
Manager classes and services for business code.

### Api
Project's controllers for api are in this package.



