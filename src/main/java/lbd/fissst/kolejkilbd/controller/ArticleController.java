package lbd.fissst.kolejkilbd.controller;


import lbd.fissst.kolejkilbd.DTO.ArticleDTO;
import lbd.fissst.kolejkilbd.messageBroker.MessageType;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private StreamBridge streamBridge;

    @PostMapping
    public String createArticle(@RequestBody ArticleDTO articleDTO){
        streamBridge.send("articleCreated-out-0", MessageType.ARTICLE_CREATED);
        return "Article created";
    }

    @PutMapping("/{articleId}")
    public String editArticle(
            @PathVariable("articleId") Long articleId,
            @RequestBody ArticleDTO articleDTO
    ){
        streamBridge.send("articleUpdated-out-0", MessageType.ARTICLE_UPDATED);
        return "Article updated";
    }
}
