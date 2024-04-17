package com.erichgamma.api.article.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.article.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
    List<Article> findByBoardId(Long id);
}
