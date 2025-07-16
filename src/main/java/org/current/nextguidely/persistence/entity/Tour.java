package org.current.nextguidely.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity(name = "tours")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "start_date", nullable = false)
	private Date startsAt;
	
	@Column(name = "end_date", nullable = false)
	private Date endsAt;

	@Column(name = "members")
	private Integer members = 1;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
	
	/*********** Relationships *************/
	@ManyToOne
	User user;
	
	@ManyToMany
	@JsonManagedReference
	List<City> cities;
}
