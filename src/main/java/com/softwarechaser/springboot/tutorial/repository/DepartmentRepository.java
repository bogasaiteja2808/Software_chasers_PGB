package com.softwarechaser.springboot.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwarechaser.springboot.tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public List<Department> findByCategory(String Category);
	public List<Department> findByDifficulty(String Difficulty);
	public List<Department> findByCategoryAndDifficulty(String Category,String Difficulty);
}
