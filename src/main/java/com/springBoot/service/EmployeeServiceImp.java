package com.springBoot.service;

import java.util.List;

import com.springBoot.entitiy.Employee;

public interface EmployeeServiceImp {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(Long empidL);

	public void deleteEmpById(Long empidL);

}
