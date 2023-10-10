package com.hca.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

	private String name;

	@Column(unique = true)
	private String username;

	private String password;

	@Column(unique = true)
	private String email;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@OneToMany(mappedBy = "user")
	private Set<Rating> ratings = new HashSet<>();

	@ManyToMany
	@JoinTable(
			name = "user_favourite",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "comic_id")
	)
	private Set<Comic> favourites = new HashSet<>();
// history
	@OneToMany(mappedBy = "user")
	private Set<History> readingHistory = new HashSet<>();

	@CreationTimestamp
	private Timestamp createdAt;

	@CreationTimestamp
	private Timestamp updateAt;

}

