package com.home.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.home.dao.EmployeeDao;
import com.home.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private  SessionFactory sessionFactory;
	
	
	@Override
	public void createEmployee(Employee employee) throws SQLException {
		Session session=sessionFactory.getCurrentSession();
		session.save(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Session session=sessionFactory.getCurrentSession();
        Employee employee=session.get(Employee.class, employeeId);
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(session.get(Employee.class, employeeId));
		System.out.println("vivek garg");
	}

	@Override
	public void updateEmployeeById(int employeeId, String newEmail) {
		Session session=sessionFactory.getCurrentSession();
		Employee employee=session.get(Employee.class, employeeId);
		employee.setEmail(newEmail);
		session.update(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session=sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Employee > cq = cb.createQuery(Employee.class);
        Root < Employee > root = cq.from(Employee.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
	}

}
