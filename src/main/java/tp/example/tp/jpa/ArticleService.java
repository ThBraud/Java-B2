package tp.example.tp.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tp.example.tp.LocaleHelper;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    public ArticleRepository articleRepository;
    @Autowired
    private LocaleHelper localeHelper;

    // getAllArticle() - Récupérer tous les articles
    public ApiResponse<List<Article>> getAllArticle() {
        List<Article> articles = articleRepository.findAll();
        String message = localeHelper.i18n("article.list.success");
        return new ApiResponse<>(202, articles, message);
    }

    // getId(id) - Récupérer un article par son ID
    public ApiResponse<Article> getId(@PathVariable("id") Long id) {
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()) {
            String message = localeHelper.i18n("article.found.success");
            return new ApiResponse<>(202, article.get(), message);
        } else {
            String message = localeHelper.i18n("article.notfound.error");
            return new ApiResponse<>(703, null, message);
        }}

    // deleteArticle(id) - Supprimer un article
    public ApiResponse<Void> deleteArticle(@PathVariable Long id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
            String message = localeHelper.i18n("article.delete.success");
            return new ApiResponse<>(202, null, message);
        } else {
            String message = localeHelper.i18n("article.notfound.error");
            return new ApiResponse<>(703, null, getAllArticle().message);
        }
    }

    // save(Article) - Créer ou modifier un article
    public ApiResponse<Article> save(Article article) {
        boolean isUpdate = (article.id != null && article.id > 0);

        Article savedArticle = articleRepository.save(article);

        if(isUpdate) {
            String message = localeHelper.i18n("article.update.success");
            return new ApiResponse<>(203, savedArticle, message);
        } else {
            String message = localeHelper.i18n("article.create.success");
            return new ApiResponse<>(202, savedArticle, message);
        }
}
}
