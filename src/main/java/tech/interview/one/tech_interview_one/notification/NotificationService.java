package tech.interview.one.tech_interview_one.notification;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private KafkaProducerService kafkaProducerService;

    public NotificationService(KafkaProducerService kafkaProducerService){
        this.kafkaProducerService = kafkaProducerService;
    }

    public void sendMessage(String message){
        this.kafkaProducerService.sendMessage(message);
    }
}
