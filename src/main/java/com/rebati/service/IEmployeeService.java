package com.rebati.service;

import java.util.List;

import com.rebati.entity.Employee;

public interface IEmployeeService {
	
	public List<Employee> retrieveEmployees();
	public Employee getEmployee(Long id);
	public void saveEmployee(Employee employee);
	

}
