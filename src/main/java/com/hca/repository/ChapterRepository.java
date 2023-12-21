package com.hca.repository;

import com.hca.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    @Query(value = "CALL HCA_COMIC_GET_CHAPTER(:idTruyen)", nativeQuery = true)
    List<Chapter> getChapterByIdTruyen(@Param("idTruyen") int idTruyen);
}
