package lbd.fissst.kolejkilbd.message_broker.consumer;

import lbd.fissst.kolejkilbd.message_broker.type.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class EventConsumer {

   @Bean
   public Consumer<MessageType> userEventConsumer() {
       return event -> System.out.println("event: " + event);
   }

    @Bean
    public Consumer<MessageType> articleEventConsumer() {
        return event -> System.out.println("event: " + event);
    }

    @Bean
    public Consumer<MessageType> commentEventConsumer() {
        return event -> System.out.println("event: " + event);
    }


}
