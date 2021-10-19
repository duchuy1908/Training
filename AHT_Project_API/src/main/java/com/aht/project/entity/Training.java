package com.aht.project.entity;

import java.sql.Date;
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
public class Training {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "training_id")
	private int id;
	@Column(name = "training_code")
	private String code;
	@Column(name = "training_name")
	private String name;
	@Column(name = "training_date_start")
	private Date dateStart;
	@Column(name = "training_date_end")
	private Date dateEnd;
	@Column(name = "training_status")
	private int status;
	@OneToMany(mappedBy = "training")
	private List<Training_Employee> training_Employees;
}
