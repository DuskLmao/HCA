package com.hca.service.truyen;

import com.hca.model.Comic;
import com.hca.model.ComicContent;

import java.util.List;

public interface TruyenService {
    Comic getTruyen(Long IdTruyen);
    ComicContent getNoiDung(Long IdTruyen, Long IdChapter);
    List<Comic> getAllTruyen();
    List<Comic> searchComicsByKeyword(String keyword);
}
