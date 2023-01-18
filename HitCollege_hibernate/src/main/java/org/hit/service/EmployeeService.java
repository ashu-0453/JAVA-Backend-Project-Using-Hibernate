package org.hit.service;

import org.hit.model.Employee;

import java.util.List;


public interface EmployeeService {
    public boolean addEmployee(Employee employee);
    public boolean updateEmployee(Employee employee /*,Integer employeeId*/ );
    public boolean deleteEmployee(Integer employeeID);
    public Employee findById(Integer employeeId);
    public List<Employee> findAll();
}
