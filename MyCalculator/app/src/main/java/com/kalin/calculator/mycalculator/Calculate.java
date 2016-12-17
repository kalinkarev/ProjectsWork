package com.kalin.calculator.mycalculator;

/**
 * Created by kalin on 16.12.16.
 */

public class Calculate {

    private long id;
    private String calculate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalculate() {
        return calculate;
    }

    public void setCalculate(String calculate) {
        this.calculate = calculate;
    }

    // Will be used to  the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return calculate;
    }

}
