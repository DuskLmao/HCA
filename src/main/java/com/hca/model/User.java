package com.hca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	private String name;

	@Column(unique = true)
	private String username;

	@JsonIgnore // remove property when return response
	private String password;

	public static String generateBcryptHash(String password) {
		String salt = BCrypt.gensalt(12);
		String hashedPassword = BCrypt.hashpw(password, salt);

		return hashedPassword;
	}

	@Column(unique = true)
	@JsonIgnore
	private String email;

	@Enumerated(EnumType.STRING)
	@JsonIgnore
	private UserRole userRole;

//	@OneToMany(mappedBy = "user")
//	@JsonIgnore
//	private Set<Rating> ratings = new HashSet<>();
//
//	@ManyToMany
//	@JsonIgnore
//	@JoinTable(
//			name = "user_favourite",
//			joinColumns = @JoinColumn(name = "user_id"),
//			inverseJoinColumns = @JoinColumn(name = "comic_id")
//	)
//	private Set<Comic> favourites = new HashSet<>();
//
//	@OneToMany(mappedBy = "user")
//	@JsonIgnore
//	private Set<History> readingHistory = new HashSet<>();

	@CreationTimestamp
	private Timestamp createdAt;

	@UpdateTimestamp
	private Timestamp updatedAt;

	private Timestamp deletedAt;

	private boolean isDeleted;

}

