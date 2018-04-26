package com.hp.emplyee.interceptor;

import java.util.Map;

import com.hp.emplyee.domain.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class authIntercentor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
//		Map<String,>arg0.getInvocationContext().getSession().get("res");
		Object obj = ActionContext.getContext().getSession().get("res");
		if(obj instanceof Employee){
			Employee employee = (Employee)obj;
			if(employee!=null){
				return arg0.invoke();
			}else{
				return "input";
			}
		}else{
			return "input";
		}
	}

}
