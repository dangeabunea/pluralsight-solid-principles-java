package hr.main;

import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;

import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        // Grab employees
        EmployeeRepository repository = new EmployeeRepository();
        List<Employee> employees = repository.findAll();

        // Save all
        for (Employee e : employees){
            Employee.save(e);
        }
    }
}
