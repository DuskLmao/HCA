package com.hca.service.truyen;

import com.hca.model.Comic;
import com.hca.model.ComicContent;

public interface TruyenService {
    Comic getTruyen(Long IdTruyen);
    ComicContent getNoiDung(Long IdTruyen, Long IdChapter);
}
