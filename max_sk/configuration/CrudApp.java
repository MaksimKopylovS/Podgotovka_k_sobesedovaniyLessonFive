package max_sk.configuration;

import max_sk.model.Model;
import max_sk.model.Students;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CrudApp {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    public static void init() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void createExampleAll(List<Students> list){
        init();
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            for(Students s : list) {
                session.save(s);
            }
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void createExample(Model model){
        init();
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void delStudents(Students students){
        init();
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.delete(students);
            session.getTransaction().commit();
            session.close();

        }
    }

    public static void updateStudent(Students students){
        init();
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.update(students);
            session.getTransaction().commit();
            session.close();

        }
    }

    public static Students findStudentById(int id){
        init();
        return sessionFactory.getSessionFactory().openSession().get(Students.class, id);
    }

    public static List<Students> getAllStudents(){
        init();
            return (ArrayList<Students>)sessionFactory.getSessionFactory().openSession().createQuery("From Students").list();
        }




}
