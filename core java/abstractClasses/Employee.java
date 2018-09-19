package abstractClass;

import java.time.*;

public class Employee extends Person
{
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salay, int year, int day)
    {
        super(name);
        this.salary=salary;
        hireDay=LocalDate.of(year,month,day);
    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public String getDescription()
    {
        return String.format("an employee with a salay of $%.2f", salary);
    }

    public void raiseSalary(double byPercent)
    {
        double raise= salary*byPercent/100;
        salary+=raise;
    }
}
