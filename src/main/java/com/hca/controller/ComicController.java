package com.hca.controller;

import com.hca.model.Comic;
import com.hca.model.ComicContent;
import com.hca.security.dto.Response;
import com.hca.service.truyen.TruyenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comic")
public class ComicController {
    private final TruyenService truyenService;

    @GetMapping("/{idtruyen}")
    public ResponseEntity<Response<Comic>> getTruyen(@PathVariable Long idtruyen) {
        Comic truyen = truyenService.getTruyen(idtruyen);
        Response<Comic> resp = new Response<>();
        resp.setSuccess(true);
        resp.setData(truyen);
        resp.setMessage("Lấy thông tin truyện thành công!");

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{idtruyen}/{idchapter}")
    public ResponseEntity<Response<ComicContent>> getNoidung(@PathVariable Long idtruyen, @PathVariable Long idchapter) {

        ComicContent content = truyenService.getNoiDung(idtruyen, idchapter);
        Response<ComicContent> resp = new Response<>();
        resp.setSuccess(true);
        resp.setData(content);
        resp.setMessage("Lấy nội dung truyện thành công!");

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/all_comic")
    public ResponseEntity<Response<List<Comic>>> getAllTruyen() {
        List<Comic> allTruyen = truyenService.getAllTruyen();
        Response<List<Comic>> resp = new Response<>();
            resp.setSuccess(true);
            resp.setData(allTruyen);
            resp.setMessage("Lấy danh sách truyện thành công!");
            return ResponseEntity.ok(resp);
    }

    @GetMapping("/search")
    public List<Comic> getTruyenByKeyword(@RequestParam  String keyword) {
        return truyenService.searchComicsByKeyword(keyword);
    }
}
