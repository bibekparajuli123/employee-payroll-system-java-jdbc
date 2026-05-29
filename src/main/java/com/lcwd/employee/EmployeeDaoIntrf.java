package com.lcwd.employee;

public interface EmployeeDaoIntrf {

    // Create Employee
    void createEmployee(Employee employee);

    // Show All Employees
    void showAllEmployee();

    // Show Employee By ID
    void showEmployeeById(int id);

    // Update Employee Name
    void updateEmployee(int id, String name);

    // Delete Employee
    void deleteEmployee(int id);

    // Generate Payroll Slip
    void generateSalarySlip(int id);
}