package com.mindprove.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindprove.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
