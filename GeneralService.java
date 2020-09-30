package com.generic.service;

import com.training.model.ContractEmployee;
import com.training.model.Employee;
import com.training.model.PermanentEmployee;
import com.training.util.SalaryCalculator;

public class GeneralService {
	
	public static void main (String arg[]){
		
PermanentEmployee pe = new PermanentEmployee();
		
		pe.setEmployeeId(1000);
		pe.setName("Kumar");
		pe.setBasicSalary(50000);
		pe.setDesignation("Developer");
		
		ContractEmployee ce = new ContractEmployee();
		
		ce.setEmployeeId(4000);
		ce.setName("Ravi");
		ce.setDailyRate(5000);
		ce.setContractPeriodInDays(20);
		
		Employee[] e = {new Employee(),pe,ce};
		
		SalaryCalculator calculator = new SalaryCalculator();
		
		for(Employee employee :e){
			
			employee.calculateSalary(1,calculator);
			
			if(employee instanceof PermanentEmployee){
				
				PermanentEmployee pe1 = (PermanentEmployee)employee;
				
				
				pe1.doPerformanceAppraisal("Excellent"); 
			}
		
		}
		
		
		
		
		
	}

}
