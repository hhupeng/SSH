package com.hp.emplyee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hp.emplyee.dao.DepartMentDao;
import com.hp.emplyee.domain.Department;

public class DepartMentDaoImpl extends HibernateDaoSupport implements DepartMentDao {

	@Override
	public List<Department> findAllByPage (int begin,int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		return this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
	}

	@Override
	public long findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0);
		}else{
			return 0;
		}
	}

	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);	
	}

	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
		
	}

	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
		
	}

	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");
	}

}
