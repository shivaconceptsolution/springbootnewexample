package com.mypackage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@ComponentScan
@EnableAutoConfiguration
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	 @Autowired
	  private EmployeeDAO employeeDao;
	 @GetMapping(
		        path = "/",
		        produces = "application/json")
		  
		    public Employees getEmployees()
		    {
		  
		        return employeeDao.getAllEmployees();
		    }
	 @PostMapping(path = "/",consumes = "application/json",produces = "application/json")
	    public ResponseEntity<Object> postEmployeeData(@RequestBody Employee employee)
	    {
		 
		     employeeDao.setAllEmployees(employee);
		     HashMap<String, String> hs = new HashMap<String, String>();
		     hs.put("msg","Insert Successfully");
		     return new ResponseEntity<>(hs,HttpStatus.OK);
	    }
	 
	 @PutMapping(
		        path = "/",
		        consumes = "application/json",
		        produces = "application/json")
	 public ResponseEntity<Object> updateEmployeeData(@RequestBody Employee emp)
	    {
		     emp.setId(emp.getId());
		     employeeDao.updateEmployee(emp);
		     HashMap<String, String> hs = new HashMap<String, String>();
		     hs.put("msg","Update Successfully");
		     return new ResponseEntity<>(hs,HttpStatus.OK);
	    }
}
