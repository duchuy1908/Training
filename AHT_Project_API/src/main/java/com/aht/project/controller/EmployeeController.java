package com.aht.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aht.project.entity.Employee;
import com.aht.project.entity.ServiceResult;
import com.aht.project.service.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public ResponseEntity<Object> getAll() {
		ServiceResult serviceResult = employeeService.findAll();
		List<Employee> employees = (List<Employee>) serviceResult.getData();
		if (employees.size() > 0) {
			return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

		ServiceResult serviceResult = employeeService.save(employee);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) {
		ServiceResult serviceResult = employeeService.delete(id);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		ServiceResult serviceResult = employeeService.update(id, employee);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
