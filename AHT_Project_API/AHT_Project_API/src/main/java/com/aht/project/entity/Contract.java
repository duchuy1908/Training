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
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contract_id")
	private int id;
	@Column(name = "contract_code")
	private String code;
	@Column(name = "contract_type")
	private int name;
	@OneToMany(mappedBy = "contract")
	private List<Contract_Employee> contract_Employees;
}
