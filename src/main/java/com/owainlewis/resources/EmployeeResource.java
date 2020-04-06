package com.owainlewis.resources;

import com.codahale.metrics.annotation.Timed;
import com.owainlewis.core.Employee;
import com.owainlewis.dao.EmployeeDAO;
import io.dropwizard.validation.Validated;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class EmployeeResource {

    private final EmployeeDAO dao;

    public EmployeeResource(EmployeeDAO employeeDAO) {
        this.dao = employeeDAO;
    }

    @GET
    @Timed
    public Response getEmployees() {
        List<Employee> employees = dao.getEmployees();
        return Response.ok(employees).build();
    }

    @POST
    public Response addEmployee(@Valid @Validated Employee employee) {
        dao.create(employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getTitle());
        return Response.accepted("").build();
    }
}
