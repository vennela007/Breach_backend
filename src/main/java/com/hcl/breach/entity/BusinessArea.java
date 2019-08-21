package com.hcl.breach.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
public class BusinessArea implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long areaId;
	private String areaName;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="franchiseId")
	private Franchise franchise;

}
