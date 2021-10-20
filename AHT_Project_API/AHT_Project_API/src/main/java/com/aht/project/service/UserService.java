package com.aht.project.service;

import org.springframework.stereotype.Service;

import com.aht.project.entity.ServiceResult;
import com.aht.project.entity.User;
import com.aht.project.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private ServiceResult serviceResult; 

	public UserService(UserRepository userRepository, ServiceResult serviceResult) {
		this.userRepository = userRepository;
		this.serviceResult = serviceResult;
	}

	public ServiceResult findAll() {
		serviceResult.setValid(true);
		serviceResult.setMessage("");
		serviceResult.setData(userRepository.findAll());
		return serviceResult;
	}

	public ServiceResult save(User user) {
			userRepository.save(user);
			serviceResult.setValid(true);
			serviceResult.setMessage("Created");
			return serviceResult;
	}
	
	public ServiceResult delete(int id) {
			userRepository.deleteById(id);
			serviceResult.setValid(true);
			serviceResult.setMessage("Deleted");
			return serviceResult;
	}
	
	public ServiceResult update(int id, User user) {
			user.setId(id);
			userRepository.save(user);
			serviceResult.setValid(true);
			serviceResult.setMessage("Updated");
			return serviceResult;
	}
}
