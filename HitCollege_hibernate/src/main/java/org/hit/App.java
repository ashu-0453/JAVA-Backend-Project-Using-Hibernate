package org.hit;

import org.hit.model.Employee;
import org.hit.service.EmployeeService;
import org.hit.service.EmployeeServiceImpl;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        int empid;
        EmployeeService service = new EmployeeServiceImpl();
        Employee employee;
        do {
            System.out.println("1-> Add Employee 2-> Update 3-> Delete 4->Search 5. Display 6. Exit");
            ch=sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Employee Details: ");
                    employee = new Employee(sc.nextInt(), sc.next(), sc.nextInt());
                    service.addEmployee(employee);
                    break;
                case 2:
                    System.out.println("Enter Employee ID to modify: ");
                    empid=sc.nextInt();
                    employee=service.findById(empid);
                    if(employee==null){
                        System.out.println("Record not found");
                    }
                    else {
                        System.out.println("Existing data: ");
                        System.out.println(employee);
                        System.out.println("Enter name and salary to update: ");
                        employee.setEmployeeName(sc.next());
                        employee.setEmployeeSalary(sc.nextInt());
                        service.updateEmployee(employee);
                        System.out.println("Record Updated");
                    }
                    break;
                case 3:
                    System.out.println("Enter employee  ID to delete: ");
                    empid=sc.nextInt();
                    employee=service.findById(empid);

                    if(employee==null){
                        System.out.println("Record not found");
                    }
                    else {
                       service.deleteEmployee(empid);
                        System.out.println("Deleted Record: ");
                        System.out.println(employee);
                        System.out.println("Record Deleted Successfully");
                    }
                    break;
                case 4:
                    System.out.println("Enter the Employee ID to Search : ");
                    empid=sc.nextInt();
                    employee=service.findById(empid);
                    if(employee==null){
                        System.out.println("Record Not found");
                    }
                    else
                    {
                        System.out.println(employee);
                    }
                    break;

                case 5:
                    service.findAll().forEach(System.out::println);
                    break;
                case 6:
                    break;
            }
        }while (ch != 6) ;
    }
}
