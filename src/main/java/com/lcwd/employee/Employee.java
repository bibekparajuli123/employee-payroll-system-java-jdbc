package com.lcwd.employee;

public class Employee {

    private int id;
    private String name;
    private int age;

    private double basicSalary;
    private double hra;
    private double da;
    private double tax;
    private double pf;

    public Employee() {
    }

    public Employee(int id, String name, int age,
                    double basicSalary,
                    double hra,
                    double da,
                    double tax,
                    double pf) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.tax = tax;
        this.pf = pf;
    }

    // Payroll Calculations

    public double getGrossSalary() {
        return basicSalary + hra + da;
    }

    public double getTotalDeductions() {
        return tax + pf;
    }

    public double getNetSalary() {
        return getGrossSalary() - getTotalDeductions();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", basicSalary=" + basicSalary +
                ", hra=" + hra +
                ", da=" + da +
                ", tax=" + tax +
                ", pf=" + pf +
                ", grossSalary=" + getGrossSalary() +
                ", netSalary=" + getNetSalary() +
                '}';
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getDa() {
        return da;
    }

    public void setDa(double da) {
        this.da = da;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }
}