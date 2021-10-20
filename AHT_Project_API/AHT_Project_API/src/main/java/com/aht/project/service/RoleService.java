package com.aht.project.service;

import org.springframework.stereotype.Service;

import com.aht.project.entity.Role;
import com.aht.project.entity.ServiceResult;
import com.aht.project.repository.RoleRepository;

@Service
public class RoleService {
	private RoleRepository roleRepository;
	private ServiceResult serviceResult; 

	public RoleService(RoleRepository roleRepository, ServiceResult serviceResult) {
		this.roleRepository = roleRepository;
		this.serviceResult = serviceResult;
	}

	public ServiceResult findAll() {
		serviceResult.setValid(true);
		serviceResult.setMessage("");
		serviceResult.setData(roleRepository.findAll());
		return serviceResult;
	}

	public ServiceResult save(Role role) {
			roleRepository.save(role);
			serviceResult.setValid(true);
			serviceResult.setMessage("Created");
			return serviceResult;
	}
	
	public ServiceResult delete(int id) {
			roleRepository.deleteById(id);
			serviceResult.setValid(true);
			serviceResult.setMessage("Deleted");
			return serviceResult;
	}
	
	public ServiceResult update(int id, Role role) {
			role.setId(id);
			roleRepository.save(role);
			serviceResult.setValid(true);
			serviceResult.setMessage("Updated");
			return serviceResult;
	}
}
