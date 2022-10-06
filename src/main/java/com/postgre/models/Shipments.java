package com.postgre.models;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import com.postgre.models.enums.AccountRole;
import com.postgre.models.enums.PackageStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="shipments")
public class Shipments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long boxId;

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
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@Getter
	@Setter
	private PackageStatus packageStatus;


	public Shipments(Long boxId, String receiverName, int weightKg, String boxColor, String destinationCountry,
			double price, Date created_at, PackageStatus packageStatus) {
		super();
		this.boxId = boxId;
		this.receiverName = receiverName;
		this.weightKg = weightKg;
		this.boxColor = boxColor;
		this.destinationCountry = destinationCountry;
		this.price = price;
		this.created_at = created_at;
		this.packageStatus = packageStatus;
	}


	public Shipments() {

	}
}
