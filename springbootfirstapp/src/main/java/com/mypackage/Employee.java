package com.mypackage;
import javax.persistence.*;
@Entity
@Table(name="employee")
public class Employee {
	@Id
	private Integer id;
	 @Column(name="firstname") 
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column
    private String email;
    public Employee()
    {
    	
    }
    public Employee(
            Integer id, String firstName,
            String lastName, String email)
        {
      
            super();
      
            this.id = id;
      
            this.firstName = firstName;
      
            this.lastName = lastName;
      
            this.email = email;
      
               
        }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
	public String toString()
    {
  
        return "Employee [id="
            + id + ", firstName="
            + firstName + ", lastName="
            + lastName + ", email="
            + email + "]";
  
           
    }
}
