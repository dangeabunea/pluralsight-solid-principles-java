package hr.data;

import hr.personnel.Employee;
import hr.personnel.FullTimeEmployee;
import hr.personnel.PartTimeEmployee;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/*
Helper method to get all employees. In reality this would be a JPA repository or something
similar
 */

public class EmployeeRepository {
    public List<Employee> findAll(){
        Employee anna = new FullTimeEmployee("Anna Smith", 2000);
        Employee billy = new FullTimeEmployee("Billy Leech", 920);

        Employee steve = new PartTimeEmployee("Steve Jones", 800);
        Employee magda = new PartTimeEmployee("Magda Iovan", 920);

        return Arrays.asList(anna, billy, steve, magda);
    }
}
