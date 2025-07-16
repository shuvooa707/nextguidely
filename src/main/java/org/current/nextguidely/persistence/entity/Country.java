package org.current.nextguidely.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "coutries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	
	/*********** Relationships *************/
	
	@OneToMany
	@JsonBackReference
	private List<City> cities;
}
