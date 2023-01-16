package org.example;

import org.example.model.Actor;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(org.example.model.Actor.class).addAnnotatedClass(Movie.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();


        try (sessionFactory){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();


            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);

             session.getTransaction().commit();


        }

    }
}
