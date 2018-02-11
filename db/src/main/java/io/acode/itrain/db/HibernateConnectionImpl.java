package io.acode.itrain.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateConnectionImpl implements HibernateConnection {
    SessionFactory sessionFactory;

    public HibernateConnectionImpl() {
        connect();
    }

    @Override
    public void connect() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Override
    public void disconnect() {
        sessionFactory.close();
        sessionFactory = null;
    }

    @Override
    public boolean isConnected() {
        try {
            Session session = getSession();
            boolean connected = session.isConnected();
            session.close();
            return connected;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public void save(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List get(String queryString) {
        Session session = getSession();
        Query query = session.createQuery(queryString);
        List results = query.list();
        session.close();
        return results;
    }

    @Override
    public Object get(int id, Class clas) {
        Session session = getSession();
        Object object = session.get(clas, id);
        session.close();
        return object;
    }

    Session getSession() {
        return sessionFactory.openSession();
    }
}
