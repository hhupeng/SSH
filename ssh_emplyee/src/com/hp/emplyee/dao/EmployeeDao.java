package com.hp.emplyee.dao;

import java.util.List;

import com.hp.emplyee.domain.Department;
import com.hp.emplyee.domain.Employee;

public interface EmployeeDao {
  public Employee findByUserNameAndPassword(Employee employee);

public long findCount();

public List<Employee> findAllByPage(int begin, int i);

public void save(Employee employee);

public void update(Employee employee);

public void delete(Employee employee);

public Employee finById(int eid);
}
