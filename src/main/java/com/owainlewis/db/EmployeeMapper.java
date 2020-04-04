package com.owainlewis.db;

import com.owainlewis.core.Employee;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Employee(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
    }
}

