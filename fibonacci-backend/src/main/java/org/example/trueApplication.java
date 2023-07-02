package org.example;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.example.resources.FibonacciResource;

import java.util.EnumSet;

public class trueApplication extends Application<trueConfiguration> {

    public static void main(final String[] args) throws Exception {
        new trueApplication().run(args);
    }

    @Override
    public String getName() {
        return "true";
    }

    @Override
    public void initialize(final Bootstrap<trueConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final trueConfiguration configuration, final Environment environment) {
        // Enable CORS support
        final FilterRegistration.Dynamic corsFilter = environment.servlets()
                .addFilter("CORSFilter", CrossOriginFilter.class);
        corsFilter.setInitParameter("allowedOrigins", "*");
        corsFilter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        corsFilter.setInitParameter("allowedMethods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
        corsFilter.setInitParameter("exposedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        corsFilter.setInitParameter("supportsCredentials", "true");
        corsFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        FibonacciResource fibonacciResource = new FibonacciResource();
        environment.jersey().register(fibonacciResource);
    }
}
