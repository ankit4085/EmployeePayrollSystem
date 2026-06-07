import java.util.ArrayList;
import java.util.Scanner;
abstract class Employee
{
    private String name;
    private int id;
    public Employee(String name,int id)
    {
        this.name=name;
        this.id=id;
    }

    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id; 
    }
    public abstract double calculate(); 
    
    @Override
    
    public String toString() 
    {
        
        return "Employee [name="+name+", id=" +id+", salary="+calculate()+"]"  ;  
    }
}
class FullTime extends Employee{  
    private double monthlySalary;
    public FullTime(String name, int id,double monthlySalary)
    {
        super (name,id); 
        this.monthlySalary =monthlySalary;

    }
    @Override
    public double calculate()
    {
        return monthlySalary;
    }

}
class PartTime extends Employee
{
    private int hoursWorked;
    private double hourlyrate;
    public PartTime(String name,int id,int hoursWorked,double hourlyrate )
    {
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyrate=hourlyrate;

    }
    @Override  
    public double calculate()
    {
        return hoursWorked * hourlyrate;
    }
}
class payrollsystem
{
    private ArrayList<Employee>employeeList;  
    public payrollsystem()
    {
        employeeList =new ArrayList<>();
    }
    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }
    public void removeEmployee(int id)
    {
        Employee employeeToRemove=null;
        for(Employee employee:employeeList) 
        {
                if(employee.getId()==id) 
                {
                    employeeToRemove=employee;
                    break;
                }
        }
        if(employeeToRemove!=null) 
        {
            employeeList.remove(employeeToRemove);
            
           
        }
        else
        {
            System.out.println("\t\t\t<******Employee data does not found******>");
        }
    }
    public void displayemployee()
    {
        for(Employee employee:employeeList)
        {
            System.out.println(employee);
        }
    }
}

public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        payrollsystem payroll=new payrollsystem();

        while(true)//java in 1 is not allowed
        {
            System.out.println("\nEnter 1 for FullTime Employee");
            System.out.println("Enter 2 for Partime Employee");
            System.out.println("Enter 3 for Remove Employee");
            System.out.println("Enter 4 for Display Detail");
            System.out.println("Enter 0 for Exit");
            System.out.print("Enter your Choice:");
            int ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.print("Enter Name:");
                    String name = sc.next();
                    System.out.print("Enter ID:");
                    int id = sc.nextInt();
                    System.out.print("Enter Salary:");
                    double salary = sc.nextDouble();
                    FullTime fulltime=new FullTime(name,id,salary); 
                    payroll.addEmployee(fulltime); 
                    break;
                case 2:
                    System.out.print("Enter Name:");
                    String pname = sc.next();
                            
                    System.out.print("Enter ID:");
                    int pid = sc.nextInt();
                            
                    System.out.print("Enter Hours Worked:");
                    int hours = sc.nextInt();
                            
                    System.out.print("Enter Hourly Rate:");
                    double rate = sc.nextDouble();
                            
                    PartTime parttime = new PartTime(pname, pid, hours, rate);
                    payroll.addEmployee(parttime);
                    break;
                case 3:
                    System.out.print("Enter ID of Remove Employee:");
                    int e_id = sc.nextInt();
                    payroll.removeEmployee(e_id);
                    break;
                case 4:
                    System.out.println("\t\t\t<<Employee Details>>\n");
                     payroll.displayemployee();
                     break;
                case 0:
                    sc.close();
                    System.exit(0);
                    
                default:
                    System.out.println("\t\t\tINVALID CHOICE");

            }
            

        }     
    }

    
}