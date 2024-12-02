1. Database have been integrated with the CRUD Application

2. Till "Updated and Documented of the DB CRUD Application : 16th Nov 24 - 13:30"(7th Commit) 
the RestAPI does provide Status response 200-OK for all the cases, but that's not a correct way. 

3. HTTP Responses and everything are covered inside the "HTTP-Responses.md" file.

        github.com/utakarsh23/SpringBoot-Complete/blob/main/HTTP-Responses.md
        
4. On the Commit "Added about HTTP Responses and what are the uses, also updated Readme"
    added the HTTP Responses for all the operations. 
5. Added Comments for the previous code without deleting so reader can compare them to get through about what's happening.

6. Added the authentication to all the endpoints and also assigned a role 'ADMIN' which can check DB, USERS, and everythin that normal users with roles 'USER' can not do.

7. Users can update their own Data(Notes/UserName/Password), but can not touch or exploit any other users data, only admin has such authority.

8. we can run our SB application by diff ways, 

        i) RUN/DEBUG ~~ Compiler/IDE
        ii) CL ~~ run mvn(running as maven project)

            To run it as a maven project->
            - go to terminal, open the target directory ("/target")
            - run 'mvn package' 
            - run 'java -jar "app nane".jar'

9. We can also change the internal configuration of the application

        while running 'java -jar "app nane".jar', just add '--property=value'
         -> java -jar RestAPI-0.0.1-SNAPSHOT.jar --property=value 
         -> java -jar RestAPI-0.0.1-SNAPSHOT.jar --server.port=8092 

10. Priority of the properties will be :

            Command Line property > application.properties > application.yml

11. Included the test of the application, we can always check for the working of the specific method, we can test and gather efficiency for our application and gather reports. "src/test/java/com/example/crud/Service".

12. Using JUnit(Jupiter) we can test our methods

13. We can do profiling b/w development/production using .yml file source, 

         Check this out for the same:
         https://youtu.be/WRUVixDFI6s?si=lnYrjlo8Ai0cYrLz