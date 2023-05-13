package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import jm.task.core.jdbc.util.Util;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {  // запомнить DDL I DML
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    private Transaction transtacion = null;

    public void createUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(
                            "CREATE TABLE IF NOT EXISTS user (" +
                                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                                    "name VARCHAR(255) NOT NULL, " +
                                    "lastName VARCHAR(255) NOT NULL, " +
                                    "age TINYINT NOT NULL" +
                                    ")")
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transtacion != null) {
                transtacion.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String last_Name, byte age) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(new User(name, last_Name, age));
            transaction.commit();
        } catch (Exception e) {
            if (transtacion != null) {
                transtacion.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<User> query = session.createQuery("FROM User", User.class);
            userList = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transtacion != null) {
                transtacion.rollback();
            }
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transtacion != null) {
                transtacion.rollback();
            }
        }
    }
}