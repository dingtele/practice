public class ParamTest
{
    public static void main(String[] args)
    {
        //test1: methods can't modify numeric parameters

        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before:percent="+ percent);
        tripleValue(percent);
        System.out.println("After: percent="+ percent);

        //test2: method can change the state of object parameters
        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before: salary="+ harry.getSalary());
        tripeSalary(harry);
        System.out.println("After:salary="+harry.getSalary());

        //test3: methods cant attach new objects to object parameters
        System.out.println("\nTesting swap:");
        Employee a= new Employee("Alice", 70000);
        Employee b= new Employee("Bob",60000);
        System.out.println("Before:a="+ a.getName());
        System.out.println("Before:b="+ b.getName());
        swap(a,b);
        System.out.println("Before:a="+ a.getName());
        System.out.println("Before:b="+ b.getName());
    }

    public static void tripleValue(double x) //doesn't work
    {
        x=3*x;
        System.out.println("End of method:x=" + x);
    }

    public static void tripleSalary(Employee x) //works
    {
        x.raiseSalary(200);
        System.out.println("End of method: salary="+ x.getSalary())
    }
}
