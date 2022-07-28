package lbd.fissst.kolejkilbd.controller;


import lbd.fissst.kolejkilbd.DTO.ArticleDTO;
import lbd.fissst.kolejkilbd.message_broker.type.MessageType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping
    public String createArticle(@RequestBody ArticleDTO articleDTO){
        streamBridge.send("article-out-0", MessageType.ARTICLE_CREATED);
        return "Article created";
    }

    @PutMapping("/{articleId}")
    public String editArticle(
            @PathVariable("articleId") Long articleId,
            @RequestBody ArticleDTO articleDTO
    ){
        streamBridge.send("article-out-0", MessageType.ARTICLE_UPDATED);
        return "Article updated";
    }
}
