package com.feelfreetocode.springboot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feelfreetocode.springboot.exceptions.InvalidNameException;
import com.feelfreetocode.springboot.exceptions.InvalidSalaryException;
import com.feelfreetocode.springboot.models.Employee;
import com.feelfreetocode.springboot.utils.DBUtils;

@Repository("employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private DBUtils dbUtils;

	@Override
	public boolean addEmployee(Employee emp) {
		Employee employee = null;
		Connection connection = dbUtils.getConnection();

		try {
			String query = "INSERT into employees" + " (firstName , lastName , extension , email , "
					+ "officeCode , reportsTo , jobTitle , employeeNumber) values (? , ? , ? , ? , ?, ? , ? , ?)";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, emp.getFirstName());
			statement.setString(2, emp.getLastName());
			statement.setString(3, emp.getExtention());
			statement.setString(4, emp.getEmail());
			statement.setString(5, emp.getOfficeCode());
			statement.setInt(6, emp.getReportsTo());
			statement.setString(7, emp.getJobTitle());
			statement.setInt(8, emp.getEmployeeId());

			int updated = statement.executeUpdate();

			return (updated == 1) ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return false;
	}

	@Override
	public Optional<Employee> updateEmployee(Integer empId, Employee emp)
			throws InvalidSalaryException, InvalidNameException {

		String query = "UPDATE employees SET lastName = ?, firstName = ?, extension = ?,email = ?, officeCode = ?, reportsTo = ? ,jobTitle = ? WHERE employeeNumber = ?";

		Connection connection = dbUtils.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, emp.getLastName());
			statement.setString(2, emp.getFirstName());

			statement.setString(3, emp.getExtention());
			statement.setString(4, emp.getEmail());
			statement.setString(5, emp.getOfficeCode());
			statement.setInt(6, emp.getReportsTo());
			statement.setString(7, emp.getJobTitle());
			statement.setInt(8, empId);

			int updated = statement.executeUpdate();
			if (updated > 0) {
				return getEmployeeById(empId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		Connection connection = dbUtils.getConnection();
		try {

			Statement statement = connection.createStatement();
			String query = "SELECT * FROM employees ";

			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(resultSet.getInt("employeeNumber"));
				employee.setLastName(resultSet.getString("lastName"));
				employee.setFirstName(resultSet.getString("firstName"));
				employee.setExtention(resultSet.getString("extension"));
				employee.setEmail(resultSet.getString("email"));
				employee.setOfficeCode(resultSet.getString("officeCode"));
				employee.setReportsTo(resultSet.getInt("reportsTo"));
				employee.setJobTitle(resultSet.getString("jobTitle"));

				employees.add(employee);
			}

			return Optional.of(employees);
		} catch (Exception e) {

		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Employee> deleteEmploye(Integer empid) {
		Employee employee = null;
		Connection connection = dbUtils.getConnection();

		try {
			Optional<Employee> optional = getEmployeeById(empid);
			if (!optional.isPresent()) {
				return Optional.ofNullable(employee);
			} else {
				employee = optional.get();
			}
			PreparedStatement statement = connection.prepareStatement("DELETE FROM employees where employeeNumber = ?");
			statement.setInt(1, empid);
			int updated = statement.executeUpdate();

			if (updated > 0) {
				return Optional.ofNullable(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.ofNullable(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer empid) {

		Employee employee = null;
		Connection connection = dbUtils.getConnection();

		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM employees where employeeNumber = ?");
			statement.setInt(1, empid);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				employee = new Employee();
				employee.setEmployeeId(resultSet.getInt("employeeNumber"));
				employee.setLastName(resultSet.getString("lastName"));
				employee.setFirstName(resultSet.getString("firstName"));
				employee.setExtention(resultSet.getString("extension"));
				employee.setEmail(resultSet.getString("email"));
				employee.setOfficeCode(resultSet.getString("officeCode"));
				employee.setReportsTo(resultSet.getInt("reportsTo"));
				employee.setJobTitle(resultSet.getString("jobTitle"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.ofNullable(employee);

	}

	@Override
	public boolean isExists(Integer empId) {
		return getEmployeeById(empId).isPresent();
	}
}
