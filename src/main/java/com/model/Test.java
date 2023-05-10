package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test {
	public static void main(String[] args) {
//		addStudent();
//		getAll();
//		deleteStudent();
		updateStudent();
	}
	static void getAll() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Criteria crt=sess.createCriteria(Student.class);
		List<Student> list=crt.list();
		System.out.println(list);
	}
	static void addStudent() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		sess.beginTransaction();
		Student s=new Student();
		s.setCity("Kathmandu");
		s.setFname("Prakriti");
		s.setLname("Katwal");
		s.setAge(27);
		sess.save(s);
		sess.getTransaction().commit();
		sess.close();
	}
	static void deleteStudent() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		sess.beginTransaction();
		Student s=(Student) sess.get(Student.class, 3);
		sess.delete(s);
		sess.getTransaction().commit();
		sess.close();
	}
	static void updateStudent() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		sess.beginTransaction();
		Student s=(Student) sess.get(Student.class, 4);
		s.setAge(32);
		s.setFname("guncha");
		s.setLname("koi");
		s.setCity("India");
		sess.update(s);

		sess.getTransaction().commit();
		sess.close();
	}
}
