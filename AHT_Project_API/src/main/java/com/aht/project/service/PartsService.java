package com.aht.project.service;

import org.springframework.stereotype.Service;

import com.aht.project.entity.Parts;
import com.aht.project.entity.ServiceResult;
import com.aht.project.repository.PartsRepository;

@Service
public class PartsService {
	
	private PartsRepository partsRepository;
	private ServiceResult serviceResult; 

	public PartsService(PartsRepository partsRepository, ServiceResult serviceResult) {
		this.partsRepository = partsRepository;
		this.serviceResult = serviceResult;
	}

	public ServiceResult findAll() {
		serviceResult.setValid(true);
		serviceResult.setMessage("");
		serviceResult.setData(partsRepository.findAll());
		return serviceResult;
	}

	public ServiceResult save(Parts parts) {
			partsRepository.save(parts);
			serviceResult.setValid(true);
			serviceResult.setMessage("Created");
			return serviceResult;
	}
	
	public ServiceResult delete(int id) {
			partsRepository.deleteById(id);
			serviceResult.setValid(true);
			serviceResult.setMessage("Deleted");
			return serviceResult;
	}
	
	public ServiceResult update(int id, Parts parts) {
			parts.setId(id);
			partsRepository.save(parts);
			serviceResult.setValid(true);
			serviceResult.setMessage("Updated");
			return serviceResult;
	}
}
