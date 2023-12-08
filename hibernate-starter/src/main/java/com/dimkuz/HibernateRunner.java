package com.dimkuz;

import com.dimkuz.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(User.class);
        configuration.configure();


        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
//             User user = User.builder()
//                     .userName("ivan@gmail.com")
//                     .firstName("Ivan")
//                     .lastName("Ivanov")
//                     .birthDate(LocalDate.of(2000, 1, 19))
//                     .age(23)
//                     .build();
//             session.save(user);
//
//             session.getTransaction().commit();
            System.out.println("OK");
        }
    }
}
