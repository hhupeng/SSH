package com.hp.emplyee.service.impl;

import java.util.List;

import com.hp.emplyee.dao.DepartMentDao;
import com.hp.emplyee.domain.Department;
import com.hp.emplyee.domain.PageBean;
import com.hp.emplyee.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartMentDao departmentDao;

	public void setDepartmentDao(DepartMentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public PageBean<Department> findByPage(int currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//��ǰҳ��
		pageBean.setCurrPage(currPage);
		int count = (int)departmentDao.findCount();
		//�ܼ�¼��
		pageBean.setTotalCount(count);
		//ÿҳ��ʾ������
		pageBean.setPageSize(3);
		double num = count;
		//��ҳ��
		pageBean.setTotalPage((int)Math.ceil(num/3));
		//��װÿҳ��ʾ������
		int begin = (currPage - 1) * 3;
		pageBean.setList(departmentDao.findAllByPage(begin, 3));
		return pageBean;
	}

	@Override
	public void save(Department department) {
		departmentDao.save(department);
		
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
		
	}

	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
		
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

}
