package com.hca.repository;

import com.hca.model.AppVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APKFileRepository {
    void uploadAPKFile(String fileName, String fileData);
}
