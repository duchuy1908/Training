package com.aht.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Parts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parts_id")
	private int id;
	@Column(name = "parts_name")
	private String name;
	@OneToMany(mappedBy = "parts")
	private List<Department> departments;
}
