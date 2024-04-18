package com.erichgamma.api.article.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erichgamma.api.article.model.Article;
import com.erichgamma.api.article.model.ArticleDto;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
    @Query("SELECT a FROM articles a WHERE a.board.id = :boardId")
    List<Article> getArticlesByBoardId1(@Param("boardId") Long boardId);

    @Query(value = "SELECT a FROM Articles a WHERE a.board_id = :boardId", nativeQuery = true)
    List<Map<String, Object>> getArticlesByBoardId2(@Param("boardId") Long boardId);

    @Query(
        "SELECT " + 
            "new com.erichgamma.api.article.model.ArticleDto(" +
                "a.id, a.title, a.content, a.writer.username, " + 
                    "(SELECT b.title FROM boards b WHERE b.id = :boardId), " + 
                "a.regLocalDateTime, a.modLocalDateTime) " +
        "FROM articles a " +
        "WHERE a.board.id = :boardId ORDER BY a.regLocalDateTime DESC"
    )
    List<ArticleDto> getArticleDtosByBoardId(@Param("boardId") Long boardId);
}
