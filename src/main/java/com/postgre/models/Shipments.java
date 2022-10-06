package com.postgre.models;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Shipments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private int id;

	@Column(nullable = false)
	@Getter
	@Setter
	private String receiverName;

	@Getter
	@Setter
	@Column(nullable = false)
	private int weightKg;

	@Getter
	@Setter
	@Column(nullable = false)
	private String boxColor;

	@Getter
	@Setter
	@Column(nullable = false)
	private String destinationCountry;
	
	@Getter
	@Setter
	@Column(nullable = false)
	private double price;
	
	@Basic
	@Getter
	@Setter
	@Temporal(TemporalType.DATE)
	private Date created_at;
	


	public Shipments() {

	}
}
