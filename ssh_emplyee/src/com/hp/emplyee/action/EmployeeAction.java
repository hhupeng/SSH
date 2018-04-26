package com.hp.emplyee.action;

import java.util.List;

import com.hp.emplyee.domain.Department;
import com.hp.emplyee.domain.Employee;
import com.hp.emplyee.domain.PageBean;
import com.hp.emplyee.service.DepartmentService;
import com.hp.emplyee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	private EmployeeService employeeService;
	
	private DepartmentService  departmentService;
	
	private int currPage = 1;
	
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String login(){
		System.out.println("登录执行了......");
		Employee res = employeeService.login(employee);
		if(res == null){
			this.addActionError("用户名或密码错误！");
			return INPUT;
		}else{
			ActionContext.getContext().getSession().put("res", res);
		}
		return "success";
		
	}
	
	 public String findByPage(){
		   PageBean<Employee> pageBean = employeeService.findByPage(currPage);
			System.out.println(pageBean.getCurrPage() + "    " + pageBean.getTotalPage() + "    " + pageBean.getList().size());
			ActionContext.getContext().getValueStack().push(pageBean);
			return "findAll";
			
		}
	 
	 public String  saveUI(){
		 List<Department> list = departmentService.findAll();
		 ActionContext.getContext().getValueStack().set("list", list);
		 return "saveUI"; 
	 }
	 
	 public String edit(){
		 employee = employeeService.findById(employee.getEid());
		 List<Department> departments = departmentService.findAll();
		 ActionContext.getContext().getValueStack().set("list", departments);
		 return "editSuccess"; 
	 }
	 
	 public String save(){
		 employeeService.save(employee);
		 return "saveSuccess";
	 }
	 
	 public String update(){
		 employeeService.update(employee);
		 return "updateSuccess"; 
	 }
	 
	 public String delete(){
		 employee = employeeService.findById(employee.getEid());
		 employeeService.delete(employee);
		 return "deleteSuccess"; 
	 }
	 
	 
		
}
