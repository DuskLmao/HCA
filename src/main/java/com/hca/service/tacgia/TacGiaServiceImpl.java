package com.hca.service.tacgia;

import com.hca.model.Author;
import com.hca.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class TacGiaServiceImpl implements TacGiaService {
    private final AuthorRepository authorRepository;
    public List<Author> getAuthor() {
        return authorRepository.getAuthor();
    }
}
