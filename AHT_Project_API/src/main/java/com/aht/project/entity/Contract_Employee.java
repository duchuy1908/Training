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
public class Contract_Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contract_emp_id")
	private int id;
	@Column(name = "contract_emp_start_date")
	private String startDate;
	@Column(name = "contract_emp_end_date")
	private String endDate;
	@Column(name = "contract_emp_status")
	private int status;
	@ManyToOne
	@JoinColumn(name="contract_id")
	private Contract contract;
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;
}
