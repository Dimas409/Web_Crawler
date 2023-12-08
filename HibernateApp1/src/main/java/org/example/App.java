package org.example;


import org.example.model.Person;
import org.example.model.Item;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            System.out.println("Получили человека из таблицы");
            System.out.println(person);

            session.getTransaction().commit();
            System.out.println("Сессия закончилась (session.close)");

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Внутри второй транзакции");

            List<Item> items = session.createQuery("select i from Item i where i.owner.id = : personId", Item.class)
                            .setParameter("personId", person.getId()).getResultList();



            session.getTransaction().commit();

            System.out.println("Вне второй сессии сессии");

            System.out.println(items);
        }
    }
}
