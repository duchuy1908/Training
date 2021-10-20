package com.aht.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.aht.project.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
