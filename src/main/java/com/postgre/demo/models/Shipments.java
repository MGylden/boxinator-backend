package com.postgre.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.postgre.demo.models.enums.AccountRole;
import com.postgre.demo.models.enums.PackageStatus;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name="shipments")
public class Shipments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boxId;

	@Column(nullable = false)
	private String receiverName;

	@Column(nullable = false)
	private int weightKg;

	@Column(nullable = false)
	private String boxColor;

	@Column(nullable = false)
	private String destinationCountry;

	@Column(nullable = false)
	private double price;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date created_at;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PackageStatus packageStatus;

	public Shipments() {
	}

	/*
	 * @JoinColumn(name = "user_id", referencedColumnName = "id") private User user;
	 * 
	 * @JsonIgnore public User getUser(User user) { return user; }
	 * 
	 * @JsonIgnore public void setUser(User user) { this.user = user; }
	 */
}
