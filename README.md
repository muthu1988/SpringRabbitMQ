# SpringRabbitMQ
Spring Boot RabbitMQ

Publishes a Message to a Queue

Listens to the Same Queue and prints in console

RabbitMQ Created Using docker-compose up using the compose yml in the repo.

RabbitMQ Management UI : http://localhost:15672/

Retry implementation Along with Dead Queue Letter implementation

Test: 

curl -X POST \
  http://localhost:7073/rabbitmq \
  -d '{
	"queueName" : "poc.test.queue",
	"payload" : "test with payload"
}'