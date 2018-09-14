package com.maven3.hiber2;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.maven3.hiber2.Alien;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class); 
        
       // ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        Alien a = (Alien) session.get(Alien.class, 1);
        
        System.out.println(a.getAname());
        Collection<Laptop> lap = a.getLap();
        for(Laptop l:lap)
        {
        	System.out.println(l);
        }
        
        session.getTransaction().commit();
    }
}
