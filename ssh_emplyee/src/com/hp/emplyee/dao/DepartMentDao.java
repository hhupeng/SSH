package com.hp.emplyee.dao;

import java.util.List;

import com.hp.emplyee.domain.Department;

public interface DepartMentDao {
	public List<Department> findAllByPage(int begin,int pageSize);
	
	
	public long findCount();


	public void save(Department department);


	public void update(Department department);


	public void delete(Department department);


	public List<Department> findAll();
}
