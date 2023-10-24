package com.hca.service;

import com.hca.model.AppVersion;
import com.hca.repository.APKFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppVersionService {

    private final APKFileRepository apkFileRepository;

    public void uploadAPKFile(MultipartFile multipartFile) {
//        AppVersion apkFile = new AppVersion();
//        apkFile.setFileName(fileName);
//        apkFile.setFileData(fileData);
//        apkFileRepository.save(apkFile);
    }
}
