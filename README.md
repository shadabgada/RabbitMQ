# RabbitMQ

Pull the image, if not available
> docker pull rabbitmq:3-management

Run the rabbitMQ docker container
> docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3-management

Call the below endpoint to publish:

```
POST request: localhost:9292/order/{restaurantName}
Request body:
{
    "name":"pizza",
    "qty":5,
    "price":350
}
```
