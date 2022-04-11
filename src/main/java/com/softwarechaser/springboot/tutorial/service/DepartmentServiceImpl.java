package com.softwarechaser.springboot.tutorial.service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwarechaser.springboot.tutorial.entity.Department;
import com.softwarechaser.springboot.tutorial.error.DepartmentNotFoundException;
import com.softwarechaser.springboot.tutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department)
	{
		return departmentRepository.save(department);
	}
	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}
	@Override
	public Department fetchDepartmentById(Long QId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department>department= departmentRepository.findById(QId);
		
		if(!department.isPresent())
		{
			throw new DepartmentNotFoundException("Department not found");
		}
		return department.get();
	}
	@Override
	public void deleteDepartmentById(Long QId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(QId);
		
	}
	
	@Override
	public Department updateDepartment(Long QId, Department department) {
		// TODO Auto-generated method stub
		Department depDB = departmentRepository.findById(QId).get();
		if(Objects.nonNull(department.getQuestion()) &&!"".equalsIgnoreCase(department.getQuestion()))
		{
			depDB.setQuestion(department.getQuestion());
		}
		if(Objects.nonNull(department.getCategory()) && !"".equalsIgnoreCase(department.getCategory()))
		{
			depDB.setQuestion(department.getCategory());
		}
		
		return departmentRepository.save(department);
	}
	@Override
	public List<Department> fetchDepartmentByCategory(String Category) {
		// TODO Auto-generated method stub
		return departmentRepository.findByCategory(Category);
	}
	@Override
	public List<Department> fetchDepartmentByDifficulty(String Difficulty) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDifficulty(Difficulty);
	}
	@Override
	public List<Department> fetchDepartmentByCategoryAndDifficulty(String Category, String Difficulty) {
		// TODO Auto-generated method stub
		return departmentRepository.findByCategoryAndDifficulty(Category,Difficulty);
	}
	
	
	

}
