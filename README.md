**Intern ID: CITS1741**

# Employee Payroll System

A console-based Employee Payroll System developed using Java, JDBC, MySQL, and Maven.

The application allows users to manage employee records and generate payroll information through a menu-driven interface.

---

## Features

- Add Employee
- View All Employees
- Search Employee by ID
- Update Employee Details
- Delete Employee
- Generate Salary Slip
- Payroll Calculations
  - Gross Salary
  - Total Deductions
  - Net Salary

---

## Technologies Used

- Java
- JDBC
- MySQL
- Maven
- IntelliJ IDEA

---

## Database Schema

```sql
CREATE TABLE employee(
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT,
    basic_salary DECIMAL(10,2),
    hra DECIMAL(10,2),
    da DECIMAL(10,2),
    tax DECIMAL(10,2),
    pf DECIMAL(10,2)
);
```

---

## Payroll Formula

Gross Salary:

```text
Gross Salary = Basic Salary + HRA + DA
```

Net Salary:

```text
Net Salary = Gross Salary - (Tax + PF)
```

---

## Project Structure

```text
src
└── com.lcwd.employee
    ├── Main.java
    ├── Employee.java
    ├── EmployeeDaoIntrf.java
    ├── EmployeeDaoImpl.java
    └── DBConnection.java
```

## Author

Bibek Parajuli
