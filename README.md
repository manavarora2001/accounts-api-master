# account-api
The application can be started by executing the AccountAPIApp class in com.moj.accounts folder

PreRequisite to start the application:-
* JRE on machine
* Maven ,to download the dependencies
* Application will start on the port:- 8080
* Prefered tool to create the request for the application :- Postman

* Url to get the accounts :- http://localhost:8080/accounts/ ,request type :- GET
* Url to add the account :- http://localhost:8080/accounts ,request type :- POST
* Url to delete the account :- http://localhost:8080/accounts/1 , here 1 is the id of the account , request type :- DELETE

Example of the json response for the GET request :-
 {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "accountNumber": "1234"
    }
    
  

