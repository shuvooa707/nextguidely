package org.current.nextguidely.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	/*********** Relationships *************/
	
	@ManyToOne
	@JsonManagedReference
	private Country country;
	
	@OneToMany
	List<User> users;
	
	@ManyToMany
	@JsonBackReference
	List<Tour> tours;
}

