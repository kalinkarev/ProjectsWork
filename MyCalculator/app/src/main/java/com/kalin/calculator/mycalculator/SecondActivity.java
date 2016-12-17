package com.kalin.calculator.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kalin on 16.12.16.
 */

public class SecondActivity extends AppCompatActivity {

//    private CalculationsDataSource datasource;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//
//        datasource = new CalculationsDataSource(this);
//        datasource.open();
//
//        List<Calculate> values = datasource.getAllCalculations();
//
//        ArrayAdapter<Calculate> adapter =
//                new ArrayAdapter<Calculate>(this, android.R.layout.simple_list_item_1, values);
//        setListAdapter(adapter);
//    }
//
//    public void onClick(View view) {
//        @SuppressWarnings("unchecked")
//                ArrayAdapter<Calculate> adapter = (ArrayAdapter<Calculate>) getListAdapter();
//        Calculate calculate = null;
//        switch (view.getId()) {
//            case R.id.add:
//                String[] calculates = new String[] { "Cool", "Very nice", "Hate it" };
//                int nextInt = new Random().nextInt(3);
//
//                calculate = datasource.createCalculate(calculates[nextInt]);
//                adapter.add(calculate);
//                break;
//            case R.id.delete:
//                if (getListAdapter().getCount() > 0) {
//                    calculate = (Calculate)getListAdapter().getItem(0);
//                    datasource.deleteCalculate(calculate);
//                    adapter.remove(calculate);
//                }
//                break;
//        }
//        adapter.notifyDataSetChanged();
//    }
//
//    @Override
//    protected void onResume() {
//        datasource.open();
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        datasource.close();
//        super.onPause();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


}