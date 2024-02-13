How to?

Step-1 : Create a Spring Boot Project form https://start.spring.io/

Step-2 : Add dependencies : oauth2-resource, spring-web

Step-3 : Go to google console and generate client and secret

Step-4 : Add below properties to application.yml file to let our resource know the issuer uri of google :

           spring:
            security:
              oauth2:
                resourceserver:
                  jwt:
                    issuer-uri: https://accounts.google.com
                      

Step-5 : Set port and context path as below

          server:
            port: 9000
            servlet:
              context-path: /resource

            

Step-6 : Create SecurityConfig to filter which req should be authenticated.
          
          @Bean
          public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
              return http
                      .authorizeHttpRequests(req->{
                          req.anyRequest().authenticated();
                      })
                      .oauth2ResourceServer(oauth2->oauth2.jwt(Customizer.withDefaults()))
                      .build();
          }

Step-7 : Create an endpoint to test our app
  
          @RestController
          public class ResourceController {
          
              @GetMapping("/hello")
              public String helloResource() {
                  return "Hello from RESOURCE";
              }
          
              @GetMapping("/sarthak")
              public String sarthak() {
                  return "Hello from sarthak";
              }
          
          }


Step-8 : Run both the serivces https://github.com/isarthak/learn-oauth-resource and https://github.com/isarthak/learn-oauth-client

Step-9 : Test endpoint http://localhost:8080/resource/hello which is part of oauth-client and later it will be redirected to http://localhost:9000/resource/hello which is our oauth resource 

Congrats! Now every request will be authenticated using Google oauth2
                      
                  
