package lbd.fissst.kolejkilbd.message_broker.consumer;

import lbd.fissst.kolejkilbd.message_broker.type.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class emailConsumer {

    private static Logger logger = LoggerFactory.getLogger(createdEventConsumer.class);

    @Bean
    public Consumer<MessageType> emailSendConsumer() {
        return email -> {
            System.out.println("email: " + email);
        };
    }

}
