package lbd.fissst.kolejkilbd.messageBroker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class Consumers {

    @Bean
    public Consumer<MessageType> emailSendConsumer() {
        return email -> {
            System.out.println("email: " + email);
        };
    }

    @Bean
    public Consumer<MessageType> createdEventConsumer() {
        return event -> {
            System.out.println("event: " + event);
        };
    }

}
