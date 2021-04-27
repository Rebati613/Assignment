package com.rebati.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rebati.entity.Employee;
import com.rebati.service.IEmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	IEmployeeService service;

	public void setService(IEmployeeService service) {
		this.service = service;
	}
	@GetMapping("/api/employees")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Employee> getEmployees(){
		List<Employee> retrieveEmployees = service.retrieveEmployees();
		return retrieveEmployees;
	}
	
	@GetMapping("/api/employees/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Employee getEmployee(@PathVariable(name = "id")Long id) {
		return service.getEmployee(id);
	}
	
	@PostMapping("/api/employees")
	@Produces("application/json")
	@Consumes("application/json")
	public void saveEmployee(@RequestBody Employee employee) {
		service.saveEmployee(employee);
		System.out.println("Employee data saved successfully");
	}
}