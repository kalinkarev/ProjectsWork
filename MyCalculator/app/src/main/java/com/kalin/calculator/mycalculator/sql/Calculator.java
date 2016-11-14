package com.kalin.calculator.mycalculator.sql;

/**
 * Created by kalin on 04.11.16.
 */

public class Calculator {

    private long id;
    private String calculator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalculator() {
        return calculator;
    }

    public void setCalculator(String comment) {
        this.calculator = calculator;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return calculator;
    }

}