package com.softwarechaser.springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softwarechaser.springboot.tutorial.entity.Department;
import com.softwarechaser.springboot.tutorial.error.DepartmentNotFoundException;
import com.softwarechaser.springboot.tutorial.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/questions")
	public Department saveDepartment(@Valid@RequestBody Department department)
	{
		logger.error("saving departments");
		return departmentService.saveDepartment(department);
	}
	@GetMapping("/questions")
	public List<Department> fetchDepartmentList()
	{
		return departmentService.fetchDepartmentList();
	}
	@GetMapping("/questions/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long QId) throws DepartmentNotFoundException
	{
		return departmentService.fetchDepartmentById(QId);
	}
	@DeleteMapping("/questions/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long QId)
	{
		logger.error("deleting department");
		departmentService.deleteDepartmentById(QId);
		return "Department deleted successfully";
	}
	@PutMapping("/questions/{id}")
	public Department updateDepartment(@PathVariable("id") Long QId,@RequestBody Department department)
	{
		return departmentService.updateDepartment(QId,department);
	}
	
	@GetMapping("/questions/Category/{Category}")
	public List<Department> fetchDepartmentByCategory(@PathVariable("Category") String Category)
	{
		return departmentService.fetchDepartmentByCategory(Category);
	}
	
	@GetMapping("/questions/Difficulty/{Difficulty}")
	public List<Department> fetchDepartmentByDifficulty(@PathVariable("Difficulty") String Difficulty)
	{
		return departmentService.fetchDepartmentByDifficulty(Difficulty);
	}
	@CrossOrigin(origins="http://localhost:3000/")
	@GetMapping("/questions/CategoryAndDifficulty")
	public List<Department> fetchDepartmentByCategoryAndDifficulty(@RequestParam String Category,@RequestParam String Difficulty)
	
	{
		return departmentService.fetchDepartmentByCategoryAndDifficulty(Category,Difficulty);
	}

}
