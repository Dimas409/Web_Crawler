import dimkuz.entity.Birthday;
import dimkuz.entity.Company;
import dimkuz.entity.User;
import dimkuz.util.HibernateUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Set;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;

public class HibernateRunnerTest {
    @Test
    void checkOrphanRemoval(){
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
            var session = sessionFactory.openSession()){
            session.beginTransaction();

            Company company = session.get(Company.class, 9);
            company.getUsers().removeIf(user -> user.getId().equals(7L));
            session.getTransaction().commit();
        }
    }

    @Test
    void checkLazyInitialization(){
        Company company = null;
        try(var sessionFactory = HibernateUtil.buildSessionFactory();
        var session = sessionFactory.openSession()){
            session.beginTransaction();

            company = session.get(Company.class, 1);
            session.getTransaction().commit();
        }
        Set<User> users = company.getUsers();
        System.out.println(users.size());


    }

    @Test
    void deleteCompany(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();

        session.beginTransaction();

        Company company = session.get(Company.class, 2);
        session.delete(company);
        session.getTransaction().commit();

    }

    @Test
    void addUserToNewCompany(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();

        session.beginTransaction();

        Company company = Company.builder()
                .name("Facebook")
                .build();

        User user = User.builder()
                .userName("sveta@gmail.com")
                .build();
//        user.setCompany(company);
//        company.getUsers().add(user);
        company.addUser(user);

        session.save(company);

        session.getTransaction().commit();
    }

    @Test
    void oneToMany(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();

        session.beginTransaction();

        Company company = session.get(Company.class, 1);
        System.out.println("");
        session.getTransaction().commit();
    }

    @Test
    void checkGetReflectionApi() throws Exception{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.getString("firstname");
        resultSet.getString("lastname");
        resultSet.getString("username");

        Class<User> clazz = User.class;
        Constructor<User> constructor = clazz.getConstructor();
        User user = constructor.newInstance();
        Field userName = clazz.getDeclaredField("userName");
        userName.setAccessible(true);
        userName.set(user, resultSet.getString("username"));

    }
    @Test
    void checkReflectionApi() throws SQLException, IllegalAccessException {
        User user = User.builder()
                .build();
        String sql = """
                insert
                into
                %s
                (%s)
                values
                (%s)
                """;

        String tableName = ofNullable(user.getClass().getAnnotation(Table.class))
                .map(tableAnnotation -> tableAnnotation.schema() + "." + tableAnnotation.name())
                .orElse(user.getClass().getName());
        Field[] declaredFields = user.getClass().getDeclaredFields();


        String columnName = Arrays.stream(declaredFields)
                .map(field -> ofNullable(field.getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName()))
                .collect(joining(", "));

        String columnValues = Arrays.stream(declaredFields)
                .map(field -> "?")
                .collect(joining(", "));

        System.out.println(sql.formatted(tableName, columnName, columnValues));

        Connection connection = null;
        PreparedStatement preparedStatement =
                connection.prepareStatement(sql.formatted(tableName, columnName, columnValues));

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            preparedStatement.setObject(1, declaredField.get(user));
        }
    }
}
