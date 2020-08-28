package com.home.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.dao.EmployeeDao;
import com.home.dao.impl.EmployeeDaoImpl;
import com.home.model.Employee;
import com.home.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) throws SQLException {
		employeeDao.createEmployee(employee);
		
	}

	@Override
	@Transactional
	public Employee fetchEmployeeById(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int employeeId) {
		employeeDao.deleteEmployeeById(employeeId);
		
	}

	@Override
	@Transactional
	public void updateEmployeeById(int employeeId, String newEmail) {
		employeeDao.updateEmployeeById(employeeId, newEmail);
		
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployeesInfo() {
		return employeeDao.getAllEmployees();
	}

}
