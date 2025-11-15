package com.mindprove.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindprove.Entity.Employee;
import com.mindprove.Service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> create(@RequestBody Employee employees){
		return employeeService.create(employees);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee employees, @PathVariable("id") Long id){
		return employeeService.updateEmp(employees, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id) {
		return deleteEmployeeById(id);
	}
}
