# shiny-guide

It is a medicine booking application.No type of security is implemented here.

Tools used:

Backened:Springboot More than 10 APIs are created to facilitate the usecases of the project. DTOs ,service layer ,repository layer are utilised.

Frontend:Angular Here two modules are created.Admin module and Customer module. Admin module caters to Admin portal webpages(for having liberty to perform CRUD operations on products) and Customer module caters to customer specific web pages. Necessary service,interfaces, input validators are used here.Image upload is handled using Fileupload event and sent to api using formdata.In backened,it is saved as an encoded string in the database.NgOninit is the only one Lifecycle hook mostly used in this project to initialize components.No guards are used.Necessary AJAX calls are made as per usecases.

Database:RDBMS(MySQL)

ORM Tool:JPA(Hibernate) Most of the queries are written using JPQL.So its RDBMS database independent. Necessary Association mappings are utilised .Necessary constraints are given.
