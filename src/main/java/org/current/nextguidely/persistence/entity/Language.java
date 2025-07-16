package org.current.nextguidely.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
	
	
	/* Relationships */
	@ManyToMany
	List<User> user;
}
