package com.owainlewis;

import com.owainlewis.dao.EmployeeDAO;
import com.owainlewis.health.DatabaseHealthCheck;
import com.owainlewis.resources.EmployeeResource;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class EmployeeServiceApplication extends Application<EmployeeServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EmployeeServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "EmployeeService";
    }

    @Override
    public void initialize(final Bootstrap<EmployeeServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<EmployeeServiceConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(final EmployeeServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final EmployeeServiceConfiguration configuration,
                    final Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "db");
        final EmployeeDAO employeeDAO = jdbi.onDemand(EmployeeDAO.class);

        environment.jersey().register(new EmployeeResource(employeeDAO));

        environment.healthChecks().register("health",
                new DatabaseHealthCheck(jdbi, configuration.getDataSourceFactory().getValidationQuery().orElse("SELECT 1")));
    }

}
