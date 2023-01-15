package com.app.pushpendra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pushpendra.model.Employee;
import com.app.pushpendra.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	    private EmployeeRepo employeeRepo;
	 
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepo.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		this.employeeRepo.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional< Employee > optional = employeeRepo.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepo.deleteById(id);

		
	}

}
