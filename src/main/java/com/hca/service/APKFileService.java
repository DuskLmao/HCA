package com.hca.service;

import com.hca.model.AppVersion;
import com.hca.repository.APKFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class APKFileService implements APKFileRepository{
    @Autowired
    private APKFileRepository apkFileRepository;

    public void uploadAPKFile(String fileName, String fileData) {
        AppVersion apkFile = new AppVersion();
        apkFile.setFileName(fileName);
        apkFile.setFileData(fileData);
        AppVersion.save(apkFile);
    }
}
