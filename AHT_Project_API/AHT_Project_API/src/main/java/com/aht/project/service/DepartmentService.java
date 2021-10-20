package com.aht.project.service;

import org.springframework.stereotype.Service;

import com.aht.project.entity.Department;
import com.aht.project.entity.ServiceResult;
import com.aht.project.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private DepartmentRepository departmentRepository;
	private ServiceResult serviceResult;

	public DepartmentService(DepartmentRepository DepartmentRepository, ServiceResult serviceResult) {
		this.departmentRepository = DepartmentRepository;
		this.serviceResult = serviceResult;
	}

	public ServiceResult findAll() {
		serviceResult.setValid(true);
		serviceResult.setMessage("");
		serviceResult.setData(departmentRepository.findAll());
		return serviceResult;
	}

	public ServiceResult save(Department Department) {
		departmentRepository.save(Department);
		serviceResult.setValid(true);
		serviceResult.setMessage("Created");
		return serviceResult;
	}

	public ServiceResult delete(int id) {
		departmentRepository.deleteById(id);
		serviceResult.setValid(true);
		serviceResult.setMessage("Deleted");
		return serviceResult;
	}

	public ServiceResult update(int id, Department department) {
		department.setId(id);
		departmentRepository.save(department);
		serviceResult.setValid(true);
		serviceResult.setMessage("Updated");
		return serviceResult;
	}

}
