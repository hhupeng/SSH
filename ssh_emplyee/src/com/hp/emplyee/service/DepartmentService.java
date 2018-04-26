package com.hp.emplyee.service;

import java.util.List;

import com.hp.emplyee.domain.Department;
import com.hp.emplyee.domain.PageBean;

public interface DepartmentService {
      public PageBean<Department> findByPage(int currPage);

	public void save(Department department);

	public void update(Department department);

	public void delete(Department department);

	public List<Department> findAll();
      
      
}
