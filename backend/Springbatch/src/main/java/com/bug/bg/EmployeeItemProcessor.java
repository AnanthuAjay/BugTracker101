package com.bug.bg;

import org.springframework.batch.item.ItemProcessor;

import com.bug.bg.modal.Employee;

public class EmployeeItemProcessor implements ItemProcessor<Employee,Employee>{

	public Employee process(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Employee Name:"+emp.getEmpName());
		return emp;
	}

}
