package com.mikolaj.springboot.cruddemo.dao;

import com.mikolaj.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee employee = entityManager.find(Employee.class, theId);

        // return employee
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save employee
        Employee employeeDB = entityManager.merge(theEmployee);

        // return the employee
        return employeeDB;
    }

    @Override
    public void deleteById(int theId) {

        // find employee by id
        Employee employee = entityManager.find(Employee.class, theId);

        // remove employee
        entityManager.remove(employee);
    }
}
