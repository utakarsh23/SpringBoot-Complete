1. Database have been integrated with the CRUD Application

2. Till "Updated and Documented of the DB CRUD Application : 16th Nov 24 - 13:30"(7th Commit) 
the RestAPI does provide Status response 200-OK for all the cases, but that's not a correct way. 

3. HTTP Responses and everything are covered inside the "HTTP-Responses.md" file.

4. On the Commit "Added about HTTP Responses and what are the uses, also updated Readme"
    added the HTTP Responses for all the operations. 
5. Added Comments for the previous code without deleting so reader can compare them to get through about what's happening.

6. Added the authentication to all the endpoints and also assigned a role 'ADMIN' which can check DB, USERS, and everythin that normal users with roles 'USER' can not do.

7. Users can update their own Data(Notes/UserName/Password), but can not touch or exploit any other users data, only admin has such authority.
