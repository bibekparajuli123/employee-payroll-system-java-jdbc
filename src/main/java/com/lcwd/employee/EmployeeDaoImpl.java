package com.lcwd.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {

    Connection con;

    @Override
    public void createEmployee(Employee employee) {

        con = DBConnection.createDBConnection();

        String query =
                "INSERT INTO employee(id, name, age, basic_salary, hra, da, tax, pf) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, employee.getId());
            pst.setString(2, employee.getName());
            pst.setInt(3, employee.getAge());

            pst.setDouble(4, employee.getBasicSalary());
            pst.setDouble(5, employee.getHra());
            pst.setDouble(6, employee.getDa());
            pst.setDouble(7, employee.getTax());
            pst.setDouble(8, employee.getPf());

            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Employee Added Successfully!");
            } else {
                System.out.println("Employee Not Added!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {

        con = DBConnection.createDBConnection();

        String query = "SELECT * FROM employee";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println("\n--------------------------------");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Age : " + rs.getInt("age"));

                System.out.println("Basic Salary : " + rs.getDouble("basic_salary"));
                System.out.println("HRA : " + rs.getDouble("hra"));
                System.out.println("DA : " + rs.getDouble("da"));
                System.out.println("Tax : " + rs.getDouble("tax"));
                System.out.println("PF : " + rs.getDouble("pf"));

                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployeeById(int id) {

        con = DBConnection.createDBConnection();

        String query = "SELECT * FROM employee WHERE id=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println("\n--------------------------------");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Age : " + rs.getInt("age"));

                System.out.println("Basic Salary : " + rs.getDouble("basic_salary"));
                System.out.println("HRA : " + rs.getDouble("hra"));
                System.out.println("DA : " + rs.getDouble("da"));
                System.out.println("Tax : " + rs.getDouble("tax"));
                System.out.println("PF : " + rs.getDouble("pf"));

                System.out.println("--------------------------------");

            } else {

                System.out.println("Employee Not Found!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {

        con = DBConnection.createDBConnection();

        String query = "UPDATE employee SET name=? WHERE id=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, id);

            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Employee Updated Successfully");
            } else {
                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {

        con = DBConnection.createDBConnection();

        String query = "DELETE FROM employee WHERE id=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            int count = pst.executeUpdate();

            if (count > 0) {
                System.out.println("Employee Deleted Successfully");
            } else {
                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateSalarySlip(int id) {

        con = DBConnection.createDBConnection();

        String query = "SELECT * FROM employee WHERE id=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                double basicSalary = rs.getDouble("basic_salary");
                double hra = rs.getDouble("hra");
                double da = rs.getDouble("da");
                double tax = rs.getDouble("tax");
                double pf = rs.getDouble("pf");

                double grossSalary = basicSalary + hra + da;
                double deductions = tax + pf;
                double netSalary = grossSalary - deductions;

                System.out.println("\n");
                System.out.println("=====================================");
                System.out.println("         EMPLOYEE PAY SLIP");
                System.out.println("=====================================");

                System.out.println("Employee ID   : " + rs.getInt("id"));
                System.out.println("Employee Name : " + rs.getString("name"));
                System.out.println("Age           : " + rs.getInt("age"));

                System.out.println("\n------------ Earnings --------------");

                System.out.println("Basic Salary  : " + basicSalary);
                System.out.println("HRA           : " + hra);
                System.out.println("DA            : " + da);

                System.out.println("-------------------------------------");
                System.out.println("Gross Salary  : " + grossSalary);

                System.out.println("\n----------- Deductions -------------");

                System.out.println("Tax           : " + tax);
                System.out.println("PF            : " + pf);

                System.out.println("-------------------------------------");
                System.out.println("Total Deduct. : " + deductions);

                System.out.println("\n=====================================");
                System.out.println("Net Salary    : " + netSalary);
                System.out.println("=====================================");

            } else {

                System.out.println("Employee Not Found!");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}