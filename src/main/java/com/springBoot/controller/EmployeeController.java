package com.springBoot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.customException.BusinessException;
import com.springBoot.customException.ControllerException;
import com.springBoot.entitiy.Employee;
import com.springBoot.service.EmployeeServiceImp;

//Controller class to handle all the request

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	//Inject the service interface 
	@Autowired
	private EmployeeServiceImp employeeServiceImp;
	
	//Save the employee data
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		try {
		Employee empSaved=employeeServiceImp.addEmployee(employee);
		return new ResponseEntity<Employee>(empSaved,HttpStatus.CREATED);
		
		}catch(BusinessException e) {
			ControllerException ec=new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ec,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce=new ControllerException("611", "Something went wrong in the controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
				
	}
	
	@GetMapping("/All")
	public ResponseEntity <List<Employee>> getAllEmployees(){
		List<Employee> listofAll=employeeServiceImp.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listofAll,HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<?> getById(@PathVariable("empId") Long empIdL){
		try{
		Employee empRetrieveds=employeeServiceImp.getEmpById(empIdL);
		return new ResponseEntity<Employee>(empRetrieveds, HttpStatus.OK);
		
	}catch(BusinessException e) {
		ControllerException ec=new ControllerException(e.getErrorCode(), e.getErrorMessage());
		return new ResponseEntity<ControllerException>(ec,HttpStatus.BAD_REQUEST);
	}catch(Exception e) {
		ControllerException ce=new ControllerException("612", "Something went wrong in the controller");
		return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
	}
	}
	
	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") Long empidL){
		employeeServiceImp.deleteEmpById(empidL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee empSaved=employeeServiceImp.addEmployee(employee);
		return new ResponseEntity<Employee>(empSaved,HttpStatus.CREATED);
	}
}
