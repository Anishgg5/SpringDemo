package com.demo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.EmployeeEntity;
import com.demo.spring.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeEntity> getAllEmployee() {
		return (List<EmployeeEntity>) employeeRepository.findAll();
	}

	public EmployeeEntity getEmployeeById(int eid) {
		return employeeRepository.findById(eid).get();
	}

	public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}

	public EmployeeEntity updateEmployee(int eid, EmployeeEntity employee) {
		EmployeeEntity employee1 = employeeRepository.findById(eid).get();
		if (employee1 != null) {
			employee1.setEname(employee.getEname());
			employee1.setEmail(employee.getEmail());
			return employeeRepository.save(employee1);
		} else {
			return null;
		}

	}

	public void deleteEmployee(int eid) {
		employeeRepository.deleteById(eid);

	}
}
