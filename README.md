# Custom_query_AssignmentS

## Frameworks and languages used
* SpringBoot
* Java

## Data flow in the project
1. Controller - It is used to define the path flow of service.
2. Services - It is used to perform the bussiness logics to get desired out put.
3. Repository - it is used to store the data modeling methods and we create out coustom quers in this repository.
4. DataBase Design - it is used to store the data.

## Data Structure Used in Project
* ArrayList
## Project Summary
CustomQuery is where We used to store and perform custom quers the data of Students in Mysql Database.
In this project we had used MVC(Model View Controller) Design.
* When ever we click on the link the action takes place in the Contoller.
* Then it goes to Service layer to perform some business operation and according to the request we had given it will perform.
* Then it goes to the dao layer which is known as Repository layer to store and manipulate the date of user.

## API's
### Students
#### Get : fetch data
* Get All Students
```
http://localhost:8080/api/v1/student/getAll
```
* Get Student by their Name with and Keyword.
* it is param variable so we just provide the value in the params.
* Required param = firstName,lastName . 
```
http://localhost:8080/api/v1/student/getstudentbyfirstnameandlastname
```

* Get Student by their active where students are Inactive or false.
```
http://localhost:8080/api/v1/student/getallstudents/Inactive
```

* Get Student by their active where students are active or True.
```
http://localhost:8080/api/v1/student/getallstudents/active
```

* Get Student by their Name with or Keyword.
* it is param variable so we just provide the value in the params.
* Required param = firstName,lastName . 
```
http://localhost:8080/api/v1/student/getStudentsbyLastnameorfirstname
```

* Get Student by their age with lessThanOrEquals operator.
* it is param variable so we just provide the value in the params.
* Required param = age in integer format. 
```
http://localhost:8080/api/v1/student/findagelessthanorequalsage
```

* Get Student by their age with GreaterThanOrEquals operator.
* it is param variable so we just provide the value in the params.
* Required param = age in integer format. 
```
http://localhost:8080/api/v1/student/findageGreatethanorequals
```
* Get Student by their age with Between Keyword.
* it is param variable so we just provide the value in the params.
* Required param = from age ,to age. 
```
http://localhost:8080/api/v1/student/StudentAgebetween/
```
#### Post : add data
* Add Student
```
http://localhost:8080/api/v1/student/createStudent
```
#### Put : Update data
* Update Student by their Name :- required Name in String format.
* we need to provide the Pathvariable of FirstName 
```http
http://localhost:8080/api/v1/student/UpdateStudent/{firstName}
```
#### The above Links are used to perform operation on the Student.
