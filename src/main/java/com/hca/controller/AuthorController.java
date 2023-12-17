package com.hca.controller;

import com.hca.model.Author;
import com.hca.security.dto.Response;
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
@RequestMapping("/api/author")
public class AuthorController {
    private final TacGiaService tacGiaService;
    @GetMapping("/all")
    public ResponseEntity<Response<List<Author>>> getAuthor() {
        List<Author> author = tacGiaService.getAuthor();
        Response<List<Author>> resp = new Response<>();
        resp.setSuccess(true);
        resp.setData(author);
        resp.setMessage("Lấy danh sách tác giả thành công!");
        return ResponseEntity.ok(resp);
    }
}
