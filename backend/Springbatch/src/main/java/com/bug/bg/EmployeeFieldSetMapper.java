package com.bug.bg;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.bug.bg.modal.Employee;

public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {

	public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		emp.setEmpId(fieldSet.readString(0));
		emp.setEmpName(fieldSet.readString(1));
		return emp;
	}

}
