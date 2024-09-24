package tech.interview.one.tech_interview_one.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class KafkaConsumerService {

    private RestClient restClient;

    public KafkaConsumerService(RestClient.Builder builder){
        this.restClient = builder.baseUrl("https://run.mocky.io/v3/0a533b50-c9d1-47d5-accd-4265185ff27d").build();
    }
    
    @KafkaListener(topics = "my-topic", groupId = "springboot")
    public void listen(String message){
        var response = this.restClient.get().retrieve().toEntity(Notification.class);

        System.out.println("Notification status code");
        System.out.println(response.getBody());
        if(response.getStatusCode().isError() || response.getBody() == null || response.getBody().status().equals("fail")){
            throw new NotificationException("Error notifying transaction " + message);
        }
        
        System.out.println("Kafka Consumer Service");
        System.out.println("Message received by Kafka");
        System.out.println(message);
    }
}
