package tech.interview.one.tech_interview_one.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class KafkaProducerService {
    
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String message){
        System.out.println("Kafka Producer Service");
        System.out.println(message);
        this.kafkaTemplate.send("my-topic", message);
    }
}
