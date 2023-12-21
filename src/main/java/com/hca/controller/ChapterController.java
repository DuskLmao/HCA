package com.hca.controller;

import com.hca.model.Chapter;
import com.hca.security.dto.Response;
import com.hca.service.chapter.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chapter")
public class ChapterController {
    private final ChapterService chapterService;

    @GetMapping("/{idTruyen}")
    public ResponseEntity<Response<List<Chapter>>> getChapter(@PathVariable int idTruyen) {
        List<Chapter> chapters = chapterService.getAllChapters(idTruyen);
        Response<List<Chapter>> resp = new Response<>();
        resp.setSuccess(true);
        resp.setData(chapters);
        resp.setMessage("Lấy thông tin truyện thành công!");
        return ResponseEntity.ok(resp);
    }
}
