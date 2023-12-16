package com.hca.service.truyen;

import com.hca.model.Comic;

import java.util.List;

public interface TruyenService {
    Comic getTruyen(Long IdTruyen);
    String getNoiDung(Long IdTruyen, Long IdChapter);
    List<Comic> getAllTruyen();
}
