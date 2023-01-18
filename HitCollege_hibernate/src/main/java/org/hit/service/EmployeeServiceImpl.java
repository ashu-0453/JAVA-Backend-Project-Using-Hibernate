package org.hit.service;

import org.hit.model.Employee;
import org.hit.repository.EmployeeRepository;
import org.hit.repository.hibernate.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository repository =new EmployeeRepositoryImpl();

    @Override
    public boolean addEmployee(Employee employee) {
        if(repository.addEmployee(employee)==null)
        return false;
        else
            return true;
    }

    @Override
    public boolean updateEmployee(Employee employee /*, Integer employeeId*/) {
//        employee.setEmployeeID(employeeId);
//        repository.updateEmployee(employee);

        if(repository.updateEmployee(employee)==null)
        return false;
        else
            return true;
    }

    @Override
    public boolean deleteEmployee(Integer employeeID) {
        if(repository.deleteEmployee(employeeID)==null){
            return false;
        }
        else
        return true;
    }

    @Override
    public Employee findById(Integer employeeId) {
        return repository.findById(employeeId);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
