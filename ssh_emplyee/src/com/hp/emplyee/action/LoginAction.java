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
		System.out.println("��¼ִ����......");
		Employee res = employeeService.login(employee);
		if(res == null){
			this.addActionError("�û������������");
			return INPUT;
		}else{
			ActionContext.getContext().getSession().put("res", res);
		}
		return "success";
		
	}

}
