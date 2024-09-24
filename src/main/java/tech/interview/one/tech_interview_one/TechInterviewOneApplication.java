package tech.interview.one.tech_interview_one;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableJdbcAuditing
public class TechInterviewOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechInterviewOneApplication.class, args);
	}

	@Bean
	NewTopic notificationTopic() {
		return TopicBuilder.name("my-topic")
				.build();
	}

}
