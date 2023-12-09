package com.hca.repository;

import com.hca.model.AppVersion;
import com.hca.model.Chapter;
import com.hca.model.Comic;
import com.hca.model.ComicContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComicContentRepository extends JpaRepository<ComicContent, Long> {
    @Query(value = "CALL HCA_APP_COMIC_GET_COMIC(:id_truyen);", nativeQuery = true)
    List<Comic> getTruyen(@Param("id_truyen") Long idTruyen);
    @Query(value = "CALL HCA_COMIC_GET_CONTENT(:id_truyen, :id_chapter);", nativeQuery = true)
    List<ComicContent> getNoiDungTruyen(@Param("id_truyen") Long idTruyen, @Param("id_chapter") Long idChapter);
}
