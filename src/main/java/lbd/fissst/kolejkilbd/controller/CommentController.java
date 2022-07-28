package lbd.fissst.kolejkilbd.controller;

import lbd.fissst.kolejkilbd.DTO.CommentDTO;
import lbd.fissst.kolejkilbd.messageBroker.MessageType;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private StreamBridge streamBridge;

    @PostMapping
    public String createAComment(@RequestBody CommentDTO commentDTO){
        streamBridge.send("commentCreated-out-0", MessageType.COMMENT_CREATED);
        return "Comment created";
    }

    @PutMapping("/{commentId}")
    public String editComment(
            @PathVariable("commentId") Long commentId,
            @RequestBody CommentDTO commentDTO
    ){
        streamBridge.send("commentUpdated-out-0", MessageType.COMMENT_UPDATED);
        return "Comment updated";
    }

    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable("commentId") Long commentId){
        streamBridge.send("commentDeleted-out-0", MessageType.COMMENT_DELETED);
        return "Comment deleted";
    }

}
