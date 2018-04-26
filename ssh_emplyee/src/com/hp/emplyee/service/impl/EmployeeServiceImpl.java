package com.hp.emplyee.service.impl;

import com.hp.emplyee.dao.EmployeeDao;
import com.hp.emplyee.domain.Department;
import com.hp.emplyee.domain.Employee;
import com.hp.emplyee.domain.PageBean;
import com.hp.emplyee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(Employee employee) {
		Employee res = employeeDao.findByUserNameAndPassword(employee);
		return res;
	}

	@Override
	public PageBean<Employee> findByPage(int currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//当前页数
		pageBean.setCurrPage(currPage);
		int count = (int)employeeDao.findCount();
		//总记录数
		pageBean.setTotalCount(count);
		//每页显示的条数
		pageBean.setPageSize(3);
		double num = count;
		//总页数
		pageBean.setTotalPage((int)Math.ceil(num/3));
		//封装每页显示的数据
		int begin = (currPage - 1) * 3;
		pageBean.setList(employeeDao.findAllByPage(begin, 3));
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);	
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
		
	}

	@Override
	public Employee findById(int eid) {
		return employeeDao.finById(eid);
	}
}
