package com.example.sampleProject1.Controller;

import com.example.sampleProject1.Kafka.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;
    @PostMapping("/sendMessage")
    public void sendMessageToKafka(@RequestBody String message)
    {
        kafkaProducerService.sendMessage(message);
    }
}
