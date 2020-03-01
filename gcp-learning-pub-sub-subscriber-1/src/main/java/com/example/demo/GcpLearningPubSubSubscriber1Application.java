package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;

@SpringBootApplication
public class GcpLearningPubSubSubscriber1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GcpLearningPubSubSubscriber1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ProjectSubscriptionName subscriptionName =ProjectSubscriptionName.of("my-first-gcp-practical", "hello-world-subscription");
		MessageReceiver receiver =
			    new MessageReceiver() {
			      @Override
			      public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
			        // handle incoming message, then ack/nack the received message
			        System.out.println("Id : " + message.getMessageId());
			        System.out.println("Data : " + message.getData().toStringUtf8());
			        consumer.ack();
			      }
			    };
			    Subscriber subscriber = null;
			    try {
			      // Create a subscriber for "my-subscription-id" bound to the message receiver
			      subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
			      subscriber.startAsync().awaitRunning();
			      // Allow the subscriber to run indefinitely unless an unrecoverable error occurs
			      subscriber.awaitTerminated();
			    } finally {
			      // Stop receiving messages
			      if (subscriber != null) {
			        subscriber.stopAsync();
			      }
	}

}
}
