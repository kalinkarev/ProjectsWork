package com.kalin.calculator.mycalculator.sql;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.kalin.calculator.mycalculator.R;

import java.util.List;
import java.util.Random;

public class SecondActivity extends ListActivity {

    private CalculatorsDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        datasource = new CalculatorsDataSource(this);
        datasource.open();

        List<Calculator> values = datasource.getAllCalculators();

        // use the SimpleCursorAdapter to show the elements in a ListView
        ArrayAdapter<Calculator> adapter = new ArrayAdapter<Calculator>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Will be caleed via the onClick attribute of the buttons in activity_second.xml

    public void onClick(View view) {
        @SuppressWarnings("unchecked")
                ArrayAdapter<Calculator> adapter = (ArrayAdapter<Calculator>)getListAdapter();
        Calculator calculator = null;
        switch(view.getId()) {
            case R.id.add:
                String[] calculators = new String[] {"Cool", "Very nice", "Hate it" };
                int nextInt = new Random().nextInt(3);
                // save the the calculator to the database
                calculator = datasource.createCalculator(calculators[nextInt]);
                adapter.add(calculator);
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    calculator = (Calculator)getListAdapter().getItem(0);
                    datasource.deleteCalculator(calculator);
                    adapter.remove(calculator);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//    }

//    ResultData data;
//    data.setResult(data.getResult());
}