package com.hca.service.category;

import com.hca.model.Author;
import com.hca.model.Category;
import com.hca.repository.AuthorRepository;
import com.hca.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> getCategory() {
        return categoryRepository.getCategory();
    }
}
