package lbd.fissst.kolejkilbd.controller;

import lbd.fissst.kolejkilbd.DTO.CommentDTO;
import lbd.fissst.kolejkilbd.messageBroker.MessageType;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private StreamBridge streamBridge;

    @PostMapping
    public String createAComment(@RequestBody CommentDTO commentDTO){
        streamBridge.send("emailSend-out-0", MessageType.EMAIL_SEND);
        return "Email created";
    }

}
