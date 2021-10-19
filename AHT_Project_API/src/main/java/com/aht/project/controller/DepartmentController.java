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

import com.aht.project.entity.Department;
import com.aht.project.entity.ServiceResult;
import com.aht.project.service.DepartmentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/department")
public class DepartmentController {
	
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping
	public ResponseEntity<Object> getAll() {
		ServiceResult serviceResult = departmentService.findAll();
		List<Department> departments = (List<Department>) serviceResult.getData();
		if (departments.size()>0) {
			return new ResponseEntity<>(serviceResult.getData(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping
	public ResponseEntity<Object> addEmployee(@RequestBody Department department) {

		ServiceResult serviceResult = departmentService.save(department);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteDepartment(@PathVariable("id") int id) {
		ServiceResult serviceResult = departmentService.delete(id);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody Department department) {
		ServiceResult serviceResult = departmentService.update(id, department);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult.getMessage(),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
