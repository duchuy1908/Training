package com.aht.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.aht.project.entity.User;

public interface UserRepository extends CrudRepository<User,Integer>{
    User findByName(String name);
}
