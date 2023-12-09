package com.hca.service.truyen;

import com.hca.model.Comic;

public interface TruyenService {
    Comic getTruyen(Long IdTruyen);
    String getNoiDung(Long IdTruyen, Long IdChapter);
}
