package com.maven3.hiber;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       /* AlienName an = new AlienName();
        an.setFname("sameer");
        an.setMname("M");
        an.setLname("Shaikh");
        
        Alien a = new Alien();
        a.setAid(103);
        a.setColor("green");
        a.setAname(an);*/
        
        /*Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Lenevo");
        
        
        Student s = new Student();
        s.setRollno(1);
        s.setName("sam");
        s.setMarks(70);
        s.getLaptop().add(laptop);
        
        laptop.getStudent().add(s);*/
        
        Alien2 a = null;
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien2.class); 
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session1 = sf.openSession();
        
        session1.beginTransaction();
        
        Query q1 = session1.createQuery("from Alien2 where aid = 201");    
        q1.setCacheable(true);
        
       // session.save(laptop);
       // session.save(s);
        a = (Alien2) q1.uniqueResult();
        System.out.println(a);
      //  tn.commit();
        
      session1.getTransaction().commit();
      
      Session s2 = sf.openSession();
      s2.beginTransaction();
      Query q2 = s2.createQuery("from Alien2 where aid = 201");    
   //   q2.setCacheable(true);
      System.out.println(a);
      s2.getTransaction().commit();
      
      
    }
}
