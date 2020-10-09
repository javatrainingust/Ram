package com.training.service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.training.dataaccess.PermanentEmployeeDAO;
import com.training.dataaccess.PermenantEmployeeDAOImpl;
import com.training.model.PermanentEmployee;

public class PermanentEmployeeService {
	
PermanentEmployeeDAO permanentEmployeeDAOImpl;
	
	public PermanentEmployeeService(){
		
		permanentEmployeeDAOImpl = new PermenantEmployeeDAOImpl();
		
	} 
	
	
	public List<PermanentEmployee> getAllPermanentEmployees() {
		
		
		
		
		List permanentEmployeeList = permanentEmployeeDAOImpl.getAllPermanentEmployees();
		
		
		Iterator<PermanentEmployee> iterator = permanentEmployeeList.iterator();
		
		while(iterator.hasNext()){
			
			PermanentEmployee pe = iterator.next();
			
			System.out.println("Employee Id "+pe.getEmployeeId());
			System.out.println("Employee name "+pe.getName());
			System.out.println("Employee designation "+pe.getDesignation());
			System.out.println("Employee basic salary "+pe.getBasicSalary());
			
			}			
			
			
		return permanentEmployeeList;
		
		
		
	}
	
	
	
	public PermanentEmployee getPermanentEmployeeByEmployeeId(int employeeId) {
		
		
		
		
		PermanentEmployee pe = permanentEmployeeDAOImpl.getPermanentEmployeeByEmployeeId(employeeId);
		
		
		System.out.println("Employee Id "+pe.getEmployeeId());
		System.out.println("Employee name "+pe.getName());
		System.out.println("Employee designation "+pe.getDesignation());
		System.out.println("Employee basic salary "+pe.getBasicSalary());
		
		return pe;
		
		
		
		
	}
		
		
	public void deletePermanentEmployee(int employeeId) {
		
		
		
		
		permanentEmployeeDAOImpl.deletePermanentEmployee(employeeId);
		
	}	
		
		
		
		
	public List<PermanentEmployee>	getAllPermanentEmployeesSortedByNames(){
		
		
		List<PermanentEmployee> permanentEmployeeList = permanentEmployeeDAOImpl.getAllPermanentEmployees();
		
		//Collections.sort(permanentEmployeeList);
		
		Stream<PermanentEmployee> permanentEmployeeStream = permanentEmployeeList.stream();
		
		Stream<PermanentEmployee> sortedStream = permanentEmployeeStream.sorted();
		
		List sortedPermenantEmployeeList = sortedStream.collect(Collectors.toList());
		
		
		Iterator<PermanentEmployee> iterator = sortedPermenantEmployeeList.iterator();
		
		while(iterator.hasNext()){
			
			PermanentEmployee pe = iterator.next();
			
			System.out.println("Employee Id "+pe.getEmployeeId());
			System.out.println("Employee name "+pe.getName());
			System.out.println("Employee designation "+pe.getDesignation());
			System.out.println("Employee basic salary "+pe.getBasicSalary());
			
			}			
		
		
		
		return permanentEmployeeList;
	}
	
	
	
public List<PermanentEmployee>	getAllPermanentEmployeesSortedByBasicSalary(){
		
		
		List<PermanentEmployee> permanentEmployeeList = permanentEmployeeDAOImpl.getAllPermanentEmployees();
		
		//Collections.sort(permanentEmployeeList,new SalaryComparator());
		
		Stream<PermanentEmployee> permanentEmployeeStream = permanentEmployeeList.stream();
		
		Stream<PermanentEmployee> sortedStream = permanentEmployeeStream.sorted(new SalaryComparator());
		
		List sortedPermenantEmployeeList = sortedStream.collect(Collectors.toList());
		
		
		Iterator<PermanentEmployee> iterator = sortedPermenantEmployeeList.iterator();
		
		while(iterator.hasNext()){
			
			PermanentEmployee pe = iterator.next();
			
			System.out.println("Employee Id "+pe.getEmployeeId());
			System.out.println("Employee name "+pe.getName());
			System.out.println("Employee designation "+pe.getDesignation());
			System.out.println("Employee basic salary "+pe.getBasicSalary());
			
			}			
		
		
		
		return permanentEmployeeList;
	}
		
public void addPermanentEmployee(PermanentEmployee permanentEmployee) {
	
	boolean isAdded = permanentEmployeeDAOImpl.addPermanentEmployee(permanentEmployee);
	
	if(!isAdded){
		
		System.out.println("The employee already exist");
	}
	else{
		System.out.println("The employee successfully added");
		
	}
	
}
		
public void updatePermanentEmployee(PermanentEmployee permanentEmployee){
	
	permanentEmployeeDAOImpl.updatePermanentEmployee(permanentEmployee);
}

}
