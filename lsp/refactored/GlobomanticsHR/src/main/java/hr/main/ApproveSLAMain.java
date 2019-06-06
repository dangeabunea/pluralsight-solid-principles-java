package hr.main;

import hr.logging.ConsoleLogger;
import hr.persistence.EmployeeFileSerializer;
import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;
import hr.personnel.ServiceLicenseAgreement;
import hr.personnel.Subcontractor;

import java.util.List;

public class ApproveSLAMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Define SLA
        int minTimeOutPercent = 98;
        int maxResolutionDays = 2;
        ServiceLicenseAgreement companySla = new ServiceLicenseAgreement(
                minTimeOutPercent,
                maxResolutionDays);

        // Grab subcontractors
        List<Employee> employees = repository.findAll();

        for (Employee e : employees){
            if(e instanceof  Subcontractor){
                Subcontractor s = (Subcontractor)e;
                s.approveSLA(companySla);
            }
        }
    }
}
