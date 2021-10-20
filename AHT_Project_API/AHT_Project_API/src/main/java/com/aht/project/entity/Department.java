package com.aht.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private int id;
	@Column(name = "department_name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "parts_id")
	private Parts parts;
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
}
