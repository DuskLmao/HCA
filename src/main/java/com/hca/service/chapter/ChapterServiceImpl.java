package com.hca.service.chapter;

import com.hca.model.Chapter;
import com.hca.model.Comic;
import com.hca.repository.ChapterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {
    private final ChapterRepository chapterRepository;
    @Override
    public List<Chapter> getAllChapters(int idTruyen) {
        List<Chapter> content = chapterRepository.getChapterByIdTruyen(idTruyen);
        return content;
    }
}
