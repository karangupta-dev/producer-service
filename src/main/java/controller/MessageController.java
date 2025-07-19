package controller;


import model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping(value = "/api")
public class MessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Map<String, String> messageBody) {
        String content = messageBody.get("content");
        String sender = messageBody.get("sender");

        Message message = new Message(content, sender);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);

        return "Message sent successfully!";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from service!";
    }

}