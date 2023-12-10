package com.hca.service.truyen;

import com.hca.model.Comic;
import com.hca.model.ComicContent;
import com.hca.repository.ComicContentRepository;
import com.hca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TruyenServiceImpl implements TruyenService {
    private final UserRepository userRepository;
    private final ComicContentRepository comicContentRepository;

    public Comic getTruyen(Long IdTruyen) {
        List<Comic> content = comicContentRepository.getTruyen(IdTruyen);
        return content.get(0);
    }
    public String getNoiDung(Long IdTruyen, Long IdChapter) {
        List<ComicContent> content = comicContentRepository.getNoiDungTruyen(IdTruyen, IdChapter);
        return content.get(0).getContent();
    }
}
