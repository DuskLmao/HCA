package com.hca.service.appversion;

import com.hca.configuration.UploadFileConfiguration;
import com.hca.model.AppVersion;
import com.hca.model.User;
import com.hca.repository.AppVersionRepository;
import com.hca.repository.UserRepository;
import com.hca.security.utils.SecurityConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppVersionServiceImpl implements AppVersionService {
    private final AppVersionRepository appVersionRepository;
    private final UserRepository userRepository;
    public AppVersion uploadAPKFile(MultipartFile file) {
        AppVersion apkFile = new AppVersion();
        var fileName = file.getOriginalFilename();
        var fileSize = file.getSize();

        Path uploadPath = Paths.get(UploadFileConfiguration.UploadDir);

        if (file.isEmpty()) {
            // Handle the case when no file is selected for upload

        } else {
            try (InputStream inputStream = file.getInputStream()) {
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }



                /// get current time
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyyHHmmss");

                Path filePath = uploadPath.resolve(formatter.format(date) + fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

                // Provide a success message
                String username = SecurityConstants.getAuthenticatedUsername();
                User loggedInUser = userRepository.findByUsername(username);

                apkFile.setFileName(fileName);
                apkFile.setFileData(fileSize);
                apkFile.setFilePath(String.valueOf(filePath));
                apkFile.setCreatorUserID(loggedInUser.getId());

                appVersionRepository.save(apkFile);
            } catch (IOException e) {
                // Handle exceptions, e.g., if there are issues with file I/O
                log.error(e.getMessage());
            }
        }



        return apkFile;
    }

    public Resource downloadAPKFile(Long fileId) {
        var file = appVersionRepository.findById(fileId);

        if (file.isPresent()) {
            try {
                Path dirPath = Paths.get(file.get().getFilePath());
                return new UrlResource(dirPath.toUri());
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }
    }

    public AppVersion getAPKFileInfo(Long id) {
        var file = appVersionRepository.findById(id);
        return file.orElse(null);
    }
}
