package com.maven3.hiber;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcom App 2");
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Laptop2.class); 
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session1 = sf.openSession();
        
        session1.beginTransaction();
       
        //inserting values in laptop2 table
       /* Random r = new Random();
        
        for (int i=2;i<=50;i++)
        {
        	Laptop2 s = new Laptop2();
        	s.setId(i);
        	s.setBrand("name "+i);
        	s.setPrice(r.nextInt(10000));
        	session1.save(s);
        }*/
        
      /*  Laptop2 l =new Laptop2();
        l.setId(51);
        l.setBrand("Asus");
        l.setPrice(5000);
        
        session1.save(l);
        
        */
        
        //session1.detach(l);//to  detach the object 
        //session1.remaove(l);//to remove the object 
        
        //using load()
        //if objecte is not found load gives exception and get gives null
        Laptop2 lap = (Laptop2) session1.load(Laptop2.class,52);
        System.out.println(lap);
        
        session1.getTransaction().commit();
	}

}
