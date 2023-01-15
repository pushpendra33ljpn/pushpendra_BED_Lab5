package com.app.pushpendra.service;
import com.app.pushpendra.model.Employee;
import java.util.List;

//import org.springframework.stereotype.Service;


public interface EmployeeService {
   //method declaration for getting the list of employees
	List<Employee> getAllEmployees();
	//method declaration for adding new employee
	 void addEmployee(Employee employee);
	 //method declaration for getting the employee details for which you want to perform update operation
	 Employee getEmployeeById(long id);
	 //method declaration for the delete operation
	 void deleteEmployeeById(long id);
}
