package lbd.fissst.kolejkilbd.message_broker.consumer;

import lbd.fissst.kolejkilbd.message_broker.type.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class EmailConsumer {

    @Bean
    public Consumer<MessageType> emailSendConsumer() {
        return event -> System.out.println("event: " + event);
    }

}
