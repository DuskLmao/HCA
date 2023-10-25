package com.hca.repository;

import com.hca.model.AppVersion;
import com.hca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APKFileRepository extends JpaRepository<AppVersion, Long> {
}
