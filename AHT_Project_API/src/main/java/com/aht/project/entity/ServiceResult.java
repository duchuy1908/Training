package com.aht.project.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ServiceResult {
		private boolean isValid;
		private Object data;
		private String message; 
}
