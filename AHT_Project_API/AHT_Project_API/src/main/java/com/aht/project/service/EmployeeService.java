package com.aht.project.service;


import org.springframework.stereotype.Service;

import com.aht.project.entity.Employee;
import com.aht.project.entity.ServiceResult;
import com.aht.project.repository.EmployeeRepository;


@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	private ServiceResult serviceResult; 

	public EmployeeService(EmployeeRepository employeeRepository, ServiceResult serviceResult) {
		this.employeeRepository = employeeRepository;
		this.serviceResult = serviceResult;
	}

	public ServiceResult findAll() {
		serviceResult.setValid(true);
		serviceResult.setMessage("");
		serviceResult.setData(employeeRepository.findAll());
		return serviceResult;
	}

	public ServiceResult save(Employee employee) {
			employeeRepository.save(employee);
			serviceResult.setValid(true);
			serviceResult.setMessage("Created");
			return serviceResult;
	}
	
	public ServiceResult delete(int id) {
			employeeRepository.deleteById(id);
			serviceResult.setValid(true);
			serviceResult.setMessage("Deleted");
			return serviceResult;
	}
	
	public ServiceResult update(int id, Employee employee) {
			employee.setId(id);
			employeeRepository.save(employee);
			serviceResult.setValid(true);
			serviceResult.setMessage("Updated");
			return serviceResult;
	}

}
