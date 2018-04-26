package com.hp.emplyee.action;

import com.hp.emplyee.domain.Employee;
import com.hp.emplyee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction  extends ActionSupport implements ModelDriven<Employee>{

	
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	Employee employee = new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
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

}
