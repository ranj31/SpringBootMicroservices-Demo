Demo Application Microservices with Spring Boot 2.0, Eureka and Spring Cloud
The main purpose of this Demo application is to provide a brief summary of the most important
components provided by these frameworks that help you in creating microservices.
The topics covered in this article are:

Using Spring Boot 2.0 in cloud-native development
Providing service discovery for all microservices with Spring Cloud Netflix Eureka
Distributed configuration with Spring Cloud Config
API Gateway pattern using a new project inside Spring Cloud: Spring Cloud Gateway
Correlating logs with Spring Cloud Sleuth Before we proceed to the source code.
It illustrates the architecture of our sample system. We have three independent microservices,
which register themself in service discovery, fetch properties from configuration service and communicate with each other.
The whole system is hidden behind API gateway.


