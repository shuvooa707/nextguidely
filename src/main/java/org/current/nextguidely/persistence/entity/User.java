package org.current.nextguidely.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, unique = false)
	private String name;

	@Column(name = "dob", nullable = false)
	private Date dob;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "moto", nullable = false)
	private String moto;
	
	@Column(name = "about", nullable = false)
	private String about;
	
	@Column(name = "description", nullable = false)
	private String description;

//	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Instant createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "thumbnail", columnDefinition = "default 'default-avatar.jpg'")
	private String thumbnail;

	@Enumerated(EnumType.ORDINAL)
	private Gender gender;

	@Enumerated(EnumType.ORDINAL)
	private Role role = Role.USER;
	
	/* Relationships */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "city_id", nullable = false)
	City currentCity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "origin_city_id", nullable = false)
	City originCity;
	
	@ManyToMany
	List<Language> languages;
	
	@OneToMany
	List<Tour> tours;
}
