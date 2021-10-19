package com.aht.project.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Training_Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "training_emp_id")
	private int id;
	@Column(name = "training_emp_result")
	private String result;
	@ManyToOne
	@JoinColumn(name="training_id")
	private Training training;
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;
}
