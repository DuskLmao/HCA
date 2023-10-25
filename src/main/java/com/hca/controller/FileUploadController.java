package com.hca.controller;

import com.hca.repository.APKFileRepository;
import com.hca.service.AppVersionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private AppVersionService appVersionService;
    @PostMapping("/apk")
    public ResponseEntity<String> uploadAPKFile(@RequestParam("file") MultipartFile file) {

//        appVersionService.uploadAPKFile();
        return ResponseEntity.ok("File uploaded successfully.");
    }
}
