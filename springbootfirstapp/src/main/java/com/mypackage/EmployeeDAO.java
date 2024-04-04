package com.mypackage;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;






@Repository
public class EmployeeDAO {
	private static Employees list
    = new Employees();
 public Employees getAllEmployees()
{
	    Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Employee e");
		List lst =   q.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
			
			Employee emp =(Employee) it.next();
			list.getEmployeeList().add(emp);
		}
		sf.close();
		s.close();
        return list;
}
 public void setAllEmployees(Employee emp)
 {
	    Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
	    s.save(emp);
		tx.commit();
		s.close();
 }
 public void updateEmployee(Employee employee)
 {
	    Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.update(employee);
		tx.commit();
		s.close();
		
      
 }
}
