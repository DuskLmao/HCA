package com.hca.service.appversion;

import com.hca.model.AppVersion;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AppVersionService {
    AppVersion uploadAPKFile(MultipartFile multipartFile);
    Resource downloadAPKFile(Long fileId);
    AppVersion getAPKFileInfo(Long fileId);
    Resource downloadLatestAPKFile();
}
