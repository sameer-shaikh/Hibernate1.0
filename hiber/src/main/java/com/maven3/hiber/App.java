package com.maven3.hiber;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        
       /* Alien2 a = null;
        
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
      */
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student1.class); 
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session1 = sf.openSession();
        
        session1.beginTransaction();
      
        /*Random r = new Random();
        
        for (int i=1;i<=50;i++)
        {
        	Student1 s = new Student1();
        	s.setRollno(i);
        	s.setName("name"+i);
        	s.setMarks(r.nextInt(100));
        	session1.save(s);
        }*/
        	
        Query q = session1.createQuery("select name,rollno from Student1 where rollno = 10");
      //for unique single result n print all columns  
       /* Student1 student = (Student1) q.uniqueResult();
        System.out.println(student);*/
        
       // to fectch multiple rows 
       /* List<Student1>student1 = q.list();
        
        for(Student1 s : student1)
        {
        	System.out.println(s);
        }*/
        
        //unique row n only one columns
       /* Object  student = (Object) q.uniqueResult();
       System.out.println(student); */
        
        //unique row n multiple columns
        Object []  student = (Object[]) q.uniqueResult();
       /*for(Object o : student)
       {
        System.out.println(o);
               }*/
        //or
       System.out.println(student[0]+" : "+student[1]);

        session1.getTransaction().commit();
    }
}
