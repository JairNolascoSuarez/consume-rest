package com.example.consumerest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.consumerest.model.Employee;

@Service
public class EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
//	public List<Employee> getAllEmployees() {
//		RestTemplate restTemplate = new RestTemplate();
//		List<Employee> employeeList = new ArrayList<Employee>();
//		ResponseEntity<Employee[]> response = restTemplate.getForEntity("http://localhost:8080/list", Employee[].class);
//		Employee[] employees = response.getBody();
//		employeeList = Arrays.asList(employees);
//		for (Employee emp : employees) {
//			log.info(emp.toString());
//		}
//		return employeeList;
//
//	}
	
	public List<Employee> getAllEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		List<Employee> employeeList = new ArrayList<Employee>();
		//Employee[] employees = restTemplate.getForObject("http://localhost:8080/list", Employee[].class);
		Employee[] employees = restTemplate.getForObject("http://localhost:8080/listEmployees", Employee[].class);
		employeeList = Arrays.asList(employees);
		for (Employee emp : employees) {
			log.info(emp.toString());
		}
		return employeeList;

	}

//	public void insert(Employee emp){
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.postForEntity("http://localhost:8080/AddEmployee", emp, Employee[].class);
//	}	
	
	public ResponseEntity<Employee> insert(Employee emp){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForEntity("http://localhost:8080/AddEmployee", emp, Employee.class);
	}
	

	public void delete(String empNo){
		RestTemplate restTemplate = new RestTemplate();
		//return restTemplate.putForEntity("http://localhost:8080/UpdateEmployee", emp, Employee[].class);
		Map<String, String> params = new HashMap<String, String>();
	    params.put("empNo", empNo );
		restTemplate.delete("http://localhost:8080/DeleteEmployee/{empNo}", params );
	}

	
// update	
//	public List<Employee> updateEmployee() {
//		RestTemplate restTemplate = new RestTemplate();
//		List<Employee> employeeList = new ArrayList<Employee>();
//		//Employee[] employees = restTemplate.getForObject("http://localhost:8080/list", Employee[].class);
//		Employee[] employees = restTemplate.getForObject("http://localhost:8080/listEmployees", Employee[].class);
//		employeeList = Arrays.asList(employees);
//		for (Employee emp : employees) {
//			log.info(emp.toString());
//		}
//		return employeeList;
//
//	}
	
	
}
