package com.demo.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.EmployeeEntity;
import com.demo.spring.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/")
	public String home() {
		return "Welcome";
	}
	
	@GetMapping(value="/getEmployee")
	public List<EmployeeEntity> getAllEmployee(HttpServletRequest req){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping(value="/getEmployee/{eid}")
	public EmployeeEntity getEmployee(@PathVariable ("eid")int eid, HttpServletRequest req) {
		return employeeService.getEmployeeById(eid);
		
	}
	
	@PutMapping(value="/createEmployee")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee, HttpServletRequest req) {
		return employeeService.createEmployee(employee);
	}
	
	@PostMapping(value="/updateEmployee/{eid}")
	public EmployeeEntity updateEmployee(@PathVariable("eid")int eid, @RequestBody EmployeeEntity employee, HttpServletRequest req) {
		return employeeService.updateEmployee(eid,employee);
	}
	
	@DeleteMapping(value="/deleteEmployee/{eid}")
	public void deleteEmployee(@PathVariable ("eid")int eid, HttpServletRequest req) {
		employeeService.deleteEmployee(eid); 
		
	}
	
	
	
	
}
