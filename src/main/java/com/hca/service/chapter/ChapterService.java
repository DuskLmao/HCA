package com.hca.service.chapter;

import com.hca.model.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> getAllChapters(int idTruyen);
}
