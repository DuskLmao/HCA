package com.hca.controller;

import com.hca.model.Author;
import com.hca.model.Category;
import com.hca.security.dto.Response;
import com.hca.service.category.CategoryService;
import com.hca.service.tacgia.TacGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/all")
    public ResponseEntity<Response<List<Category>>> getCategory() {
        List<Category> Category = categoryService.getCategory();
        Response<List<Category>> resp = new Response<>();
        resp.setSuccess(true);
        resp.setData(Category);
        resp.setMessage("Lấy danh sách thể loại thành công!");
        return ResponseEntity.ok(resp);
    }
}
