package lbd.fissst.kolejkilbd.messageBroker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class Consumers {

    @Bean
    public Consumer<MessageType> emailSendConsumer() {
        return email -> {
            throw new RuntimeException();
        };
    }

    //Throws exception to pass message to DLQ
    @Bean
    public Consumer<MessageType> createdEventConsumer() {
        return event -> {
            throw new RuntimeException();
        };
    }

    @Bean
    public Consumer<MessageType> dlqCreatedEventConsumer() {
        return event -> {
            System.out.println("DLQ EVENT CONSUMER " + event);
        };
    }

    @Bean
    public Consumer<MessageType> dlqEmailSendConsumer() {
        return event -> {
            System.out.println("DLQ EMAIL CONSUMER " + event);
        };
    }

}
