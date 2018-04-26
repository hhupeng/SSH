package com.hp.emplyee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hp.emplyee.dao.EmployeeDao;
import com.hp.emplyee.domain.Department;
import com.hp.emplyee.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public Employee findByUserNameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ?";
		System.out.println(employee.getUsername());
		System.out.println(employee.getPassword());
		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public long findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0);
		}else{
			return 0;
		}
		
	}

	@Override
	public List<Employee> findAllByPage(int begin, int i) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Employee.class);
		return this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,i);
	}

	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
		
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
		
	}

	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
		
	}

	@Override
	public Employee finById(int eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}
}
