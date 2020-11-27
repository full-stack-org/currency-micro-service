# currency-micro-service

Services with Zuul Api endpoints
--------------------------------------------
In General
******************
Zuul port: 8765
http://localhost:8765/{App Name}/{URI}


currency-conversion-service Regular Hit
********************************************
http://localhost:8765/currency-conversion-service/currency-converter/from/AUD/to/INR/quantity/135

currency-conversion-service Feign Hit
********************************************
http://localhost:8765/currency-conversion-service/currency-converter-feign/from/EUR/to/INR/quantity/10000

currency-exchange-service
**************************
http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR

Limits Service
********************
http://localhost:8765/limits-service/limits

Eureka:
*************
http://localhost:8761/

Rabbit MQ and Zip Kin
****************************
Download Zipkin: https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec

Install Rabbit MQ:
https://www.rabbitmq.com/install-windows.html(Secind download and install)
http://www.erlang.org/downloads (First Download it)

Run Rabbit Mq with Zipkin

Open Git Bash:
set RABBIT_URI=amqp://localhost 

java -jar zipkin-server-2.12.9-exec.jar 

Cloud config server Refresh
*****************************
http://localhost:8080/actuator/refresh

http://localhost:8081/actuator/bus-refresh

