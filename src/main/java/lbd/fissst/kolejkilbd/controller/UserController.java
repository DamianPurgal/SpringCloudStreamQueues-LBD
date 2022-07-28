package lbd.fissst.kolejkilbd.controller;

import lbd.fissst.kolejkilbd.DTO.UserDTO;
import lbd.fissst.kolejkilbd.messageBroker.MessageType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private StreamBridge streamBridge;

    @PostMapping
    public String createUser(@RequestBody UserDTO userDTO){

        streamBridge.send("userCreated-out-0", MessageType.USER_CREATED);

        return "User created";
    }

}
