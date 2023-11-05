package com.hca.controller;

import com.github.javafaker.App;
import com.hca.model.AppVersion;
import com.hca.security.dto.Response;
import com.hca.service.appversion.AppVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/apk")
public class FileUploadController {

    private final AppVersionService appVersionService;

    @PostMapping("/upload")
    public ResponseEntity<Response<AppVersion>> uploadAPKFile(@RequestParam("file") MultipartFile file) {
        Response<AppVersion> res = new Response<>();


        if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".apk")) {
            res.setSuccess(false);
            res.setMessage("This API only accept APK File");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        var appVersion = appVersionService.uploadAPKFile(file);

        if (appVersion != null) {
            res.setSuccess(true);
            res.setMessage("Upload thành công");
        } else {
            res.setSuccess(false);
            res.setMessage("Upload thất bại.");
        }
        res.setData(appVersion);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<Response<AppVersion>> getAPKInfo(@PathVariable Long id) {
        Response<AppVersion> res = new Response<>();
        var appVersion = appVersionService.getAPKFileInfo(id);

        if (appVersion != null) {
            res.setMessage("Get APK Version success");
            res.setData(appVersion);
            res.setSuccess(true);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(res);
        } else {
            res.setMessage("APK File not found");
            res.setSuccess(false);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(res);
        }
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadAPKFile(@PathVariable Long id) {
        var appVersion = appVersionService.downloadAPKFile(id);

        if (appVersion != null) {
            String contentType = "application/octet-stream";
            String headerValue = "attachment; filename=\"" + appVersion.getFilename() + "\"";

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                    .body(appVersion);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/latest")
    public ResponseEntity<Resource> downloadAPKFile() {
        var appVersion = appVersionService.downloadLatestAPKFile();

        if (appVersion != null) {
            String contentType = "application/octet-stream";
            String headerValue = "attachment; filename=\"" + appVersion.getFilename() + "\"";

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                    .body(appVersion);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
