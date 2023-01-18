package org.hit.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hit.model.Employee;
import org.hit.repository.EmployeeRepository;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private SessionFactory sessionFactory;

    public EmployeeRepositoryImpl() {
        sessionFactory=DOAConfiguration.getSessionFactory();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    @Override
    public Employee deleteEmployee(Integer employeeID) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class,employeeID);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Employee> list = session.createQuery("from Employee").list();
        session.close();
        return list;
    }

    @Override
    public Employee findById(Integer employeeId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee emp = session.get(Employee.class,employeeId);
        session.getTransaction().commit();
        session.close();
        return emp;
    }
}
