package com.hca.repository;

import com.hca.model.Comic;
import com.hca.model.ComicContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComicRepository extends JpaRepository<Comic, Long> {
    @Query(value = "CALL HCA_COMIC_GET_COMIC;", nativeQuery = true)
    List<Comic> getAllTruyen();
    @Query(value = "CALL HCA_APP_COMIC_GET_COMIC_BY_KEYWORD(:keyword)", nativeQuery = true)
    List<Comic> searchComicsByKeyword(@Param("keyword") String keyword);
}
