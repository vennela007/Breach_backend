package com.hcl.breach.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
public class Breach implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer breachId;
	private String franchise;
	private String businessArea;
	private String businessCategory;
	private String description;
	private String status;
	private String riskType;
	@CreationTimestamp
	private LocalDate creationDate;
	private Integer userId;
	private Integer adminId;
}
