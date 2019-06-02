package hr.personnel;

public class Subcontractor extends Employee {

    public Subcontractor(String fullName, int monthlyIncome) {
        super(fullName, monthlyIncome);
    }

    @Override
    public void requestTimeOff(int nbDays, Employee manager) {
        throw new RuntimeException("Can not take time off;");
    }
}
