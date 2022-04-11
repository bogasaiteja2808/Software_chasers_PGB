package com.softwarechaser.springboot.tutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.softwarechaser.springboot.tutorial.entity.Department;
import com.softwarechaser.springboot.tutorial.error.DepartmentNotFoundException;
@Service
public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long QId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long QId);

	public Department updateDepartment(Long QId,Department department);

	public List<Department> fetchDepartmentByCategory(String Category);
	
	public List<Department> fetchDepartmentByDifficulty(String Difficulty);

	public List<Department> fetchDepartmentByCategoryAndDifficulty(String Category, String Difficulty);

}
