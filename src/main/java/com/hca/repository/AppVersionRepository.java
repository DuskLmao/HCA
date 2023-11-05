package com.hca.repository;

import com.hca.model.AppVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppVersionRepository extends JpaRepository<AppVersion, Long> {
    @Query(value = "CALL HCA_APPVERSION_GET_LATEST();", nativeQuery = true)
    AppVersion getLatestVersion();
}
