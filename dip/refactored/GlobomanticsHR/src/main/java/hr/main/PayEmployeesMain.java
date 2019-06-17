package hr.main;

import hr.notifications.EmailSender;
import hr.notifications.EmployeeNotifier;
import hr.payment.PaymentProcessor;
import hr.persistence.EmployeeFileRepository;
import hr.persistence.EmployeeFileSerializer;
import hr.persistence.EmployeeRepository;

public class PayEmployeesMain {

    /*
    Will take a couple of seconds to execute due to the
    sending of mails.
     */

    public static void main(String[] args) {

        EmployeeFileSerializer serializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository =
                new EmployeeFileRepository(serializer);
        EmployeeNotifier employeeNotifier = new EmailSender();
        PaymentProcessor paymentProcessor = new PaymentProcessor(
                employeeRepository,
                employeeNotifier);

        int totalPayments = paymentProcessor.sendPayments();
        System.out.println("Total payments " + totalPayments);
    }
}
