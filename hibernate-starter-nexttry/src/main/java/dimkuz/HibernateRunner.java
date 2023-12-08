package dimkuz;

import dimkuz.entity.Birthday;
import dimkuz.entity.Company;
import dimkuz.entity.PersonalInfo;
import dimkuz.entity.User;
import dimkuz.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;


@Slf4j
public class HibernateRunner {
    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Yandex")
                .build();

        User user = User.builder()
                .userName("dmitri@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .lastName("Kuznetsov")
                        .firstName("Petr")
                        .birthDate(new Birthday(LocalDate.of(2000, 1, 2)))
                        .build())
                .company(company)
                .build();



        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1){
                session1.beginTransaction();
                session1.save(user);

                session1.getTransaction().commit();

            }


        }
    }
}
