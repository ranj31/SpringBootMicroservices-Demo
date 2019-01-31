Demo Application Microservices with Spring Boot 2.0, Eureka and Spring Cloud
The main purpose of this Demo application is to provide a brief summary of the most important
components provided by these frameworks that help you in creating microservices.
The topics covered in this article are:

Using Spring Boot 2.0 in cloud-native development
Providing service discovery for all microservices with Spring Cloud Netflix Eureka
Distributed configuration with Spring Cloud Config
API Gateway pattern using a new project inside Spring Cloud: Spring Cloud Gateway
Correlating logs with Spring Cloud Sleuth Before we proceed to the source code.
The architecture of our application is that.
We have three independent microservices,(department-service,employee-service and organization-service)
which register themself in service discovery, fetch properties from configuration service and communicate with each other.
The whole system is hidden behind Zuul API gateway.

We have implemented  2ways of config server
1.config-service ->In this services configuration file available in classpath/config folder
2.configsrv ->In this services configuration file available in file system(path of my file system is D:\ran-config\config)

Both the services are running on 8060.At a time we have to run only one services.


