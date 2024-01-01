package com.springBoot.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.Repo.EmployeeCrudRepo;
import com.springBoot.customException.BusinessException;
import com.springBoot.entitiy.Employee;

//Service class to write business logic

@Service
public class EmployeeService implements EmployeeServiceImp{
	
	//inject the EmployeeCrudRepo class
	@Autowired
	EmployeeCrudRepo employeeCrudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		try {
			if(employee.getName().isEmpty() || employee.getName().length()==0) {
				throw new BusinessException("601", "Please send proper name,It blank");
			}
			Employee saveEmployee=employeeCrudRepo.save(employee);
			return saveEmployee;
		}catch(IllegalArgumentException e) {
			
			throw new BusinessException("602", "given employee is null" +e.getMessage()); 
			
		}catch(Exception e) {
			
			throw new BusinessException("603", "Something went wrong in service layer while saving the employee" + e.getMessage());
		}
		
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			List<Employee> emplist=employeeCrudRepo.findAll();
			if(emplist.isEmpty()) {
				throw new BusinessException("604", "Hey list is completelly empty,we have nothing to return");
				
			}
			return emplist;
		}
			catch(Exception e) {
				throw new BusinessException("605", "Something went wrong in service layer while retrieving the list of employee" + e.getMessage());
			}
		
	}

	@Override
	public Employee getEmpById(Long empidL) {
		try {
			return employeeCrudRepo.findById(empidL).get();
		}catch(IllegalArgumentException e) {
			
			throw new BusinessException("606", "given employee is null,please send some id to send" +e.getMessage()); 
		}catch(java.util.NoSuchElementException e) {
			
			throw new BusinessException("607", "given employee id is doesn't exist in DB" +e.getMessage()); 
		}
		
		
	}

	@Override
	public void deleteEmpById(Long empidL) {
		try {
			employeeCrudRepo.deleteById(empidL);
		}catch(IllegalArgumentException e) {
			
			throw new BusinessException("608", "given employee is null,please send some id to send" +e.getMessage()); 
		}
		
		
	}

	

}


