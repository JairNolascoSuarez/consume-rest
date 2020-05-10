package com.example.consumerest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumerest.model.Employee;
import com.example.consumerest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "employees",method = RequestMethod.GET)   // or use @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

	
	// URL - http://localhost:8080/AddEmployee
	@RequestMapping(value = "AddEmployee", method = RequestMethod.POST) // or use @GetMapping
	public void AddEmployee(@RequestBody Employee emp) {
		employeeService.insert(emp);
	}

	// URL - http://localhost:8080/DeleteEmployee/{empNo}
	@RequestMapping(value = "DeleteEmployee/{empNo}", method = RequestMethod.DELETE) // or use @GetMapping
	public void DeleteEmployee(@PathVariable("empNo") String empNo) {
		employeeService.delete(empNo);
	}

	
}
