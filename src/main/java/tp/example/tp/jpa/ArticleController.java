package tp.example.tp.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ApiVersionInserter;

import java.util.List;
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public ApiResponse<List<Article>> getAllArticle(){
        // Select all BBD
        return articleService.getAllArticle();
    }

    @GetMapping("/article/{id}")
    public ApiResponse<Article> getId(@PathVariable Long id){
        // Select all BBD
        return articleService.getId(id);
    }

    @DeleteMapping("/delete-articles/{id}")
    public ApiResponse<Void> deleteArticle (@PathVariable Long id) {
        return articleService.deleteArticle(id);
    }

    @PostMapping("/save-article")
    public ApiResponse<Article> saveArticle (@RequestBody Article article){
        return articleService.save(article);
    }
}