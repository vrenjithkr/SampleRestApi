package com.renji.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.renji.bank.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(int id);
}
