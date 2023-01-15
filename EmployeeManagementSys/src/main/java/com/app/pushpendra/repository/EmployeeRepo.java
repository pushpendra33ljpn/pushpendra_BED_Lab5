package com.app.pushpendra.repository;
import  com.app.pushpendra.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
