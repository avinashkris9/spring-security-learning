# Getting Started


Authorization Server is responsible to provide authorisation token to the client.

There are multiple oauth2 flows. Please refer to [Oauth Framework](https://tools.ietf.org/html/rfc6749) and Toptal Oauth2  [JWT-Oauth2](https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection) page for basic understanding of oauth2.


* Spring team is building official authorization server. Please refer the same.


1. Configure Authorization Client Details either through property file or extending AuthorizationServerConfigurerAdapter. Below steps are for programmatic configuration.
    - Extend AuthorizationServerConfigurerAdapter to configure client details and grant details.
    - Enable Authentication by configuring users Using WebSecurityAdaptor.

2. Send Post Request to /oauth/token end point with
    - Client Id/Secret as Basic Auth Credentials.
    - grant_type =password
    - username=xxx
    - password=yyy
 
 Eg.
 
    curl --location --request POST 'http://localhost:8080/oauth/token' \
     --header 'Authorization: Basic bW9iaWxlOnBpbg==' \
     --header 'Content-Type: application/x-www-form-urlencoded' \
     --data-urlencode 'grant_type=password' \
     --data-urlencode 'username=test' \
     --data-urlencode 'password=test123'
     
     
     
##Reference 

- [Spring Doc](https://github.com/spring-projects/spring-security/blob/e7f93f221d4b828d336627f5147a3edd02a8c28d/samples/boot/oauth2authorizationserver/src/main/java/sample/AuthorizationServerConfiguration.java#L94)