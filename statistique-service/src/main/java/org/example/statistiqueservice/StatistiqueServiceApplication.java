package org.example.statistiqueservice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertNotNull;



@SpringBootApplication
public class StatistiqueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatistiqueServiceApplication.class, args);
    }
    @Autowired
    private ApplicationContext context;

    public void doSomething() {
        doSomething();
    }

    public void notImplemented() {
        throw new UnsupportedOperationException("notImplemented() cannot be performed because ...");
    }
    @Override
    public void emptyOnPurpose() {
        // comment explaining why the method is empty
    }



}
