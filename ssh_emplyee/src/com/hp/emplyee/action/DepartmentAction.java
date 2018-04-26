package com.hp.emplyee.action;

import com.hp.emplyee.domain.Department;
import com.hp.emplyee.domain.PageBean;
import com.hp.emplyee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	
   private  DepartmentService  departmentService;
   
   private Department department = new Department();
   
   private int currPage = 1;
   
   public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
   
   public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

   @Override
   public Department getModel() {
	   return department;
   }
   
   public String findByPage(){
	   PageBean<Department> pageBean = departmentService.findByPage(currPage);
		System.out.println(pageBean.getCurrPage() + "    " + pageBean.getTotalPage() + "    " + pageBean.getList().size());
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
		
	}
   
   public String saveUI() {
		return "saveUI";	
	}
   
   public String edit() {
		return "editSuccess";	
	}
   
   
	public String save() {
		
		departmentService.save(department);
		return "saveSuccess";	
	}
	
	public String update() {
		
		departmentService.update(department);
		return "updateSuccess";	
	}
	
	public String delete() {
		
		departmentService.delete(department);
		return "deleteSuccess";	
	}
}
