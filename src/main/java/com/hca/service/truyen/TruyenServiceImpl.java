package com.hca.service.truyen;

import com.hca.model.Comic;
import com.hca.model.ComicContent;
import com.hca.repository.ComicContentRepository;
import com.hca.repository.ComicRepository;
import com.hca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TruyenServiceImpl implements TruyenService {
    private final UserRepository userRepository;
    private final ComicRepository comicRepository;
    private final ComicContentRepository comicContentRepository;

    public Comic getTruyen(Long IdTruyen) {
        Comic content = comicRepository.findById(IdTruyen).orElse(null);
        return content;
    }
    public ComicContent getNoiDung(Long IdTruyen, Long IdChapter) {
        List<ComicContent> content = comicContentRepository.getNoiDungTruyen(IdTruyen, IdChapter);
        return content.get(0);
    }
}
