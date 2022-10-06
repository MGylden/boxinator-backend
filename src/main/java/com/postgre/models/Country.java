package com.postgre.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long countryId;
	
	@Getter
	@Setter
	private String countryName;
	
	@Getter
	@Setter
	private Long fee;
	
	@Getter
	@Setter
	private int countryCode;

}
