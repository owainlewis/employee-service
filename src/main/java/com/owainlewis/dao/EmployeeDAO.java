package com.owainlewis.dao;

import com.owainlewis.core.Employee;
import com.owainlewis.db.EmployeeMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;

public interface EmployeeDAO {
    @SqlQuery("select * from employees")
    @UseRowMapper(EmployeeMapper.class)
    public List<Employee> getEmployees();

    @SqlUpdate("insert into employees (firstName, lastName, email) values (:firstName, :lastName, :email)")
    public void create(@Bind("firstName") String firstName,
                       @Bind("lastName") String lastName,
                       @Bind("email") String email);
}
