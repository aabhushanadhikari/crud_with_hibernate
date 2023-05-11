package com.model;
import java.util.Arrays;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest {
	public static void main(String[] args) {
	manyToMany();
	}
	static void oneToOne() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		sess.beginTransaction();
		Address adr=new Address();
		adr.setCity("Kathmandu");
		
		adr.setCountry("Nepal");
		adr.setState("State 3");
		sess.save(adr);
		Employee emp=new Employee();
		emp.setFname("Aabhushan");
		emp.setLname("Adhikari");
		emp.setAddress(adr);
		sess.save(emp);
		sess.getTransaction().commit();
		sess.close();
		
		
	}
	static void oneToMany() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		sess.beginTransaction();
		Address adr=new Address();
		adr.setCity("Kathmandu");
		
		adr.setCountry("Nepal");
		adr.setState("State 3");
		sess.save(adr);
		Employee emp=new Employee();
		emp.setFname("Aabhushan");
		emp.setLname("Adhikari");
		emp.setAddress(adr);
		sess.save(emp);
		Phone pn=new Phone();
		pn.setNumber(9841);
		pn.setType("NTC");
		pn.setEmployee(emp);
		sess.save(pn);
		Phone p2=new Phone();
		p2.setNumber(9863);
		p2.setType("NCELL");
		p2.setEmployee(emp);
		sess.save(p2);
		emp.setPhone(Arrays.asList(pn,p2));
		
		sess.getTransaction().commit();
		sess.close();
	}
	static void manyToMany() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		sess.beginTransaction();
		Address adr=new Address();
		adr.setCity("Kathmandu");
		
		adr.setCountry("Nepal");
		adr.setState("State 3");
		sess.save(adr);
		Employee emp=new Employee();
		emp.setFname("Aabhushan");
		emp.setLname("Adhikari");
		emp.setAddress(adr);
		sess.save(emp);
		Phone pn=new Phone();
		pn.setNumber(9841);
		pn.setType("NTC");
		pn.setEmployee(emp);
		sess.save(pn);
		Phone p2=new Phone();
		p2.setNumber(9863);
		p2.setType("NCELL");
		p2.setEmployee(emp);
		sess.save(p2);
		emp.setPhone(Arrays.asList(pn,p2));
		Department d1=new Department();
		d1.setName("IT");
		sess.save(d1);
		Department d2=new Department();
		d2.setName("QA");
		sess.save(d2);
		emp.setDepartmentList(Arrays.asList(d1,d2));
		
		
		
		
		sess.getTransaction().commit();
		sess.close();
	}
	}
	

