                                        HTTP RESPONSES 

HTTP response status codes indicate whether a specific HTTP request has been successfully completed. 
They are grouped in five classes:
1. Informational Responses 
2. Successful Responses 
3. Redirection Responses 
4. Client Error Responses 
5. Server Error Responses 

2:  => A Successful Request which is received, processed, understood by the Server 

    200 OK ->
        The Request has been successfully processed and the Server is returning the requested resource. ----> GET
    201 CREATED ->
        The request has been fulfilled and a new Resource has been created. ----->> POST 
    204 NO CONTENT ->
        The Request was successful but there is no response Body... i.e nothing gets returned --> DELETE

3:  => These status codes indicate that further action is needed to complete the request. They are used when the client needs to take additional
       steps to access the requested resource.

    301 MOVED PERMANENTLY -> 
        The requested resource has been permanently moved to a different URL.
    302 FOUND -> 
        The HTTP status code 302 indicates that the requested resource has been temporarily moved to a different URL. When a 
        server sends a response with a 302 status code, it typically includes a Location header field that specifies the new temporary URL
        where the client should redirect to.
    304 NOT MODIFIED -> 
        The client's cached version of the requested resource is still valid, so the server sends this status code 
        to indicate that the client can use its cached copy.
4:  => These status codes indicate that there was an error on the client's part, such as a malformed
       request or authentication issues.
    
    400 BAD REQUEST ->
        The server cannot understand or process the client's request due to invalid syntax or other client-side issues.
    401 UNAUTHORIZED ->
        The client needs to provide authentication credentials to access the requested resource.
    403 FORBIDDEN ->
        The client is authenticated, but it does not have permission to access the requested Resource.

5:  => These status codes indicate that there was an error on the server's part while trying to fulfill the request.

    500 INTERNAL SERVER ERROR ->
        A generic error message indicating that something went wrong on the server, and the server could not handle the request.
    502  BAD GATEWAY  ->
        The server acting as a gateway or proxy received an invalid response from an upstream server.
    503 SERVICE UNAVILABLE ->
        The server is currently unable to handle the request due to temporary overloading or maintainance.