# Read Me First

#https://www.baeldung.com/spring-security-oauth2-jws-jwk
#
* Resource Server is the actual api end point which produce the result.
* For authorisation resource server can perform any of the below.
  * Token Introspection - Connect to Authorisation server each time to validate the token.
    - This can be done by setting property token-info-uri to point to authorization server. 
    - Authorization server expose check_token
    
  * Validate the jwt token by itself without connecting the authorisation server.