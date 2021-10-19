package com.aht.project.entity;

import java.sql.Date;
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
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int id;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_dob")
	private Date dateOfBirth;
	@Column(name = "emp_sex")
	private int sex;
	@Column(name = "emp_number_insurance")
	private String numberInsurance;
	@Column(name = "emp_address")
	private String address;
	@Column(name = "emp_phone")
	private String phone;
	@Column(name = "emp_type")
	private int type;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	@OneToMany(mappedBy = "employee")
	private List<Contract_Employee> contract_Employees;
	@OneToMany(mappedBy = "employee")
	private List<Training_Employee> training_Employees;
	
}
