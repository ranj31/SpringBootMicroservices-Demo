Demo Application Microservices with Spring Boot 2.0, Eureka and Spring Cloud
The main purpose of this Demo application is to provide a brief summary of the most important
components provided by these frameworks that help you in creating microservices.
The topics covered in this article are:

Using Spring Boot 2.0 in cloud-native development
Providing service discovery for all microservices with Spring Cloud Netflix Eureka
Distributed configuration with Spring Cloud Config
API Gateway pattern using a new project inside Spring Cloud: Spring Cloud Gateway
Correlating logs with Spring Cloud Sleuth Before we proceed to the source code.
We have implemented Swagger UI for documentation purpose.

The architecture of our application is that.
We have three independent microservices,(department-service,employee-service and organization-service)
which register themself in eureka service discovery, fetch properties from configuration service and communicate with each other.
The whole system is hidden behind Zuul API gateway.

1.department-service is running on jetty server
2.employee-service is running on undertow server
3.organization-service is running on tomcat server

We have implemented  2ways of config server
1.config-service ->In this services configuration file available in classpath/config folder
2.configsrv ->In this services configuration file available in file system(path of my file system is D:\ran-config\config)

Both the services are running on 8060.At a time you have to run only one services.

sequence of services start
1.config service
2.discovery-service
3.proxy service
4.gateway-service
5.employee-service
6.department-service
7.organization-service

Once you have succesfully started application you may visit Eureka Server available under address http://localhost:8061/.

Once Eureka is succesfully started you can hit urls

http://localhost:8060/employee ->To see list of all employees
http://localhost:8060/department -> To see list of all department
http://localhost:8060/organization ->To see list of all organization

http://localhost:8060/department/organization/2/with-employees

http://localhost:8060/department/organization/2/with-employees


Here’s Swagger UI for our microservices system available under address http://localhost:8060/swagger-ui.html


