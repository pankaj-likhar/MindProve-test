package com.mindprove.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindprove.Entity.Employee;
import com.mindprove.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public ResponseEntity<Employee> getEmployeeById(Long id) {
		Optional<Employee> existingEmployee = employeeRepository.findById(id);
		return existingEmployee.map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	public ResponseEntity<Employee> create(Employee employees) {
		Employee save = employeeRepository.save(employees);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}

	public ResponseEntity<Employee> updateEmp(Employee employees, Long id) {
		Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);

		if (existingEmployeeOptional.isPresent()) {
			Employee existingEmployee = existingEmployeeOptional.get();
			existingEmployee.setName(employees.getName());
			existingEmployee.setEmail(employees.getEmail());
			existingEmployee.setDepartment(employees.getDepartment());
			existingEmployee.setSalary(employees.getSalary());
//			return employeeRepository.save(existingEmployeeOptional);
			return ResponseEntity.ok(employeeRepository.save(existingEmployee));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	public ResponseEntity<Void> deleteEmployeeById(Long id) {
		Optional<Employee> existingEmployee = employeeRepository.findById(id);

		if (existingEmployee.isPresent()) {
			employeeRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
}
