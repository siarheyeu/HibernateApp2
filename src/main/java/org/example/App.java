package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(org.example.model.Person.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();


            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }


    }
}
