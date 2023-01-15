package com.app.pushpendra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.pushpendra.model.Employee;
//import com.app.pushpendra.service.EmployeeServiceImpl;
import com.app.pushpendra.service.EmployeeService;

@Controller
public class EmpController {
	
	@Autowired
    private EmployeeService employeeService;//dependency for the controller is injected here


	//request handler for displaying list of employees
	@GetMapping("/")//"/"is for the root page or the home page
	public String homeListPage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());  //adding watever we getting from the getallemp method of service method into model and then sending that model to the veiw layer which is thymeleaf tamplate here
        return "home";
    }
 
	//Now adding the handler method for the handling of the add new employee requests.
	 @GetMapping("/registerNewEmployeeForm")
	    public String registerNewEmployeeForm(Model model) {
	        // create model attribute to bind form data
	        Employee employee = new Employee();
	        model.addAttribute("employee", employee);
	        return "newRegistration";
	    }
	 
	 //now the handler for submitNewEmpDetails
	 @PostMapping("/submitNewEmpDetails")
	    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	        // save employee to database
	        employeeService.addEmployee(employee);
	        return "redirect:/";
	    }
	 
	 @GetMapping("/updateDetailsForm/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

	        // get employee from the service
	        Employee employee = employeeService.getEmployeeById(id);

	        // set employee as a model attribute to pre-populate the form
	        model.addAttribute("employee", employee);
	        return "updateExistingEmployee";
	    }
	 
	 //now the handler for managing the request made for the deleting the existing employee details
	 
	 @GetMapping("/deleteEmployee/{id}")
	    public String deleteEmployee(@PathVariable(value = "id") long id) {
 
	        this.employeeService.deleteEmployeeById(id);
	        return "redirect:/";

}
}