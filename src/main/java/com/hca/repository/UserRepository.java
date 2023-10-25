package com.hca.repository;

import com.hca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	User findByEmail(String email);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
