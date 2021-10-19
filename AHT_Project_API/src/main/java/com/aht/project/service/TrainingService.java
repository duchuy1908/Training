package com.aht.project.service;

import org.springframework.stereotype.Service;

import com.aht.project.entity.ServiceResult;
import com.aht.project.entity.Training;
import com.aht.project.repository.TrainingRepository;

@Service
public class TrainingService {
		
	private TrainingRepository trainingRepository;
	private ServiceResult serviceResult; 

	public TrainingService(TrainingRepository trainingRepository, ServiceResult serviceResult) {
		this.trainingRepository = trainingRepository;
		this.serviceResult = serviceResult;
	}

	public ServiceResult findAll() {
		serviceResult.setValid(true);
		serviceResult.setMessage("");
		serviceResult.setData(trainingRepository.findAll());
		return serviceResult;
	}

	public ServiceResult save(Training training) {
			trainingRepository.save(training);
			serviceResult.setValid(true);
			serviceResult.setMessage("Created");
			return serviceResult;
	}
	
	public ServiceResult delete(int id) {
			trainingRepository.deleteById(id);
			serviceResult.setValid(true);
			serviceResult.setMessage("Deleted");
			return serviceResult;
	}
	
	public ServiceResult update(int id, Training training) {
			training.setId(id);
			trainingRepository.save(training);
			serviceResult.setValid(true);
			serviceResult.setMessage("Updated");
			return serviceResult;
	}
}
