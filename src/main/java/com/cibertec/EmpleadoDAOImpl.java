package com.cibertec;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {
	
    private SessionFactory sessionFactory;

    public EmpleadoDAOImpl() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    public void insertar(Empleado empleado) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(empleado);
            session.getTransaction().commit();
        }
    }

    @Override
    public void actualizar(Empleado empleado) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(empleado);
            session.getTransaction().commit();
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public void eliminar(int idEmpleado) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Empleado empleado = session.get(Empleado.class, idEmpleado);
            if (empleado != null) {
                session.delete(empleado);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public Empleado obtenerPorId(int idEmpleado) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Empleado.class, idEmpleado);
        }
    }

    @Override
    public List<Empleado> obtenerTodos() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Empleado", Empleado.class).list();
        }
    }
}
