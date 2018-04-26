package com.hp.emplyee.service;

import java.util.List;

import com.hp.emplyee.domain.Department;
import com.hp.emplyee.domain.Employee;
import com.hp.emplyee.domain.PageBean;

public interface EmployeeService {
	public Employee login(Employee employee);

	public PageBean<Employee> findByPage(int currPage);

	public void save(Employee employee);

	public void update(Employee employee);

	public void delete(Employee employee);

	public Employee findById(int eid);
}
