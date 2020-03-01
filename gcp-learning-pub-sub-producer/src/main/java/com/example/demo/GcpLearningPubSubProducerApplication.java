package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;

@SpringBootApplication
public class GcpLearningPubSubProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GcpLearningPubSubProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Publisher publisher = Publisher.newBuilder(
	            ProjectTopicName.of("my-first-gcp-practical", "hello-world"))
	            .build();
		String payload=createPayload();
		PubsubMessage pubsubMessage =
		          PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(payload)).build();
		publisher.publish(pubsubMessage);
		
	}

	private String createPayload() throws Exception {
		Model model=new Model("1","test","test123");
		ObjectMapper mapper=new ObjectMapper();
		return mapper.writeValueAsString(model);
		
	}

}
