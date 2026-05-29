package com.lcwd.employee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EmployeeDaoIntrf dao = new EmployeeDaoImpl();

        System.out.println("======================================");
        System.out.println("     EMPLOYEE PAYROLL SYSTEM");
        System.out.println("======================================");

        Scanner scan = new Scanner(System.in);

        do {

            System.out.println("\n1. Add Employee");
            System.out.println("2. Show All Employees");
            System.out.println("3. Show Employee By ID");
            System.out.println("4. Update Employee Name");
            System.out.println("5. Delete Employee");
            System.out.println("6. Generate Salary Slip");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = scan.nextInt();

            switch (choice) {

                case 1:

                    Employee employee = new Employee();

                    System.out.print("Enter Employee ID: ");
                    int id = scan.nextInt();

                    scan.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = scan.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scan.nextInt();

                    System.out.print("Enter Basic Salary: ");
                    double basicSalary = scan.nextDouble();

                    System.out.print("Enter HRA: ");
                    double hra = scan.nextDouble();

                    System.out.print("Enter DA: ");
                    double da = scan.nextDouble();

                    System.out.print("Enter Tax: ");
                    double tax = scan.nextDouble();

                    System.out.print("Enter PF: ");
                    double pf = scan.nextDouble();

                    employee.setId(id);
                    employee.setName(name);
                    employee.setAge(age);

                    employee.setBasicSalary(basicSalary);
                    employee.setHra(hra);
                    employee.setDa(da);
                    employee.setTax(tax);
                    employee.setPf(pf);

                    dao.createEmployee(employee);

                    break;

                case 2:

                    dao.showAllEmployee();

                    break;

                case 3:

                    System.out.print("Enter Employee ID: ");

                    int empId = scan.nextInt();

                    dao.showEmployeeById(empId);

                    break;

                case 4:

                    System.out.print("Enter Employee ID: ");

                    int updateId = scan.nextInt();

                    scan.nextLine();

                    System.out.print("Enter New Name: ");

                    String newName = scan.nextLine();

                    dao.updateEmployee(updateId, newName);

                    break;

                case 5:

                    System.out.print("Enter Employee ID: ");

                    int deleteId = scan.nextInt();

                    dao.deleteEmployee(deleteId);

                    break;

                case 6:

                    System.out.print("Enter Employee ID: ");

                    int salarySlipId = scan.nextInt();

                    dao.generateSalarySlip(salarySlipId);

                    break;

                case 0:

                    System.out.println("Thank you for using Employee Payroll System!");

                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (true);
    }
}