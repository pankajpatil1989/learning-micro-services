# Micro-services (beginning stage)

### Environment and used concepts/technologies 

* Spring Boot 2.3.1
* Build Tool - maven
#### Micro-services (RESTful webservices used)
* 1] limit-service
* 2] currency-exchange-service
* 3] currency-conversion-service

### spring-cloud-config-server
* Spring Cloud Config is Spring's client/server approach for storing and serving distributed configurations across multiple applications and environments.
* To share property values between different services
### spring-cloud-starter-openfeign
* Feign is a declarative web service client. It makes writing web service clients easier.
### spring-cloud-starter-netflix-ribbon
* Ribbon is a client-side load balancer that gives you a lot of control over the behavior of HTTP and TCP clients.
### spring-cloud-starter-bus-amqp
* The Spring Cloud Bus provides feature to refresh configurations across multiple instances.
* The primary usage is to broadcast configuration changes or other management information.
### netflix-eureka-naming-server
* Eureka naming server is an application that holds information about all client service applications. Each microservice registers itself with the Eureka naming server.
* Client-side service discovery allows services to find and communicate with each other without hard-coding hostname and port.
### netflix-zuul-api-gateway-server
* Zuul is an edge service that proxies requests to multiple backing services. It provides a unified “front door” to your ecosystem.
* Cross cutting concerns such as authentication, security, monitoring, CORS etc. will be handled by the gateway
### spring-cloud-starter-sleuth
* It introduces unique IDs to your logging which are consistent between microservice calls which makes it possible to find how a single request travels from one microservice to the next.
### zipkin-server-2.21.5
* Zipkin is an open source project that provides mechanisms for sending, receiving, storing, and visualizing traces.
* Distributed Tracing is crucial for troubleshooting and understanding microservices. It is very useful when we need to track the request passing through multiple microservices.
### org.springframework.amqp (RabbitMQ used as implementation)
* AMQP is an open standard wire specification for asynchronous message communication.
* Spring RabbitMQ is the message broker based on Spring AMQP protocol implementation.
### spring-cloud-starter-netflix-hystrix
* Spring Cloud Netflix Hystrix – the fault tolerance library.
* Hystrix is watching methods for failing calls to related services. If there is such a failure, it will open the circuit and forward the call to a fallback method.