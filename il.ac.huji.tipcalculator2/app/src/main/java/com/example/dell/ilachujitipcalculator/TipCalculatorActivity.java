package com.example.dell.ilachujitipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean boxCheck(View view){
        boolean checked = ((CheckBox) view).isChecked();
        return checked;
    }
    public void clicked(View view){
        EditText editText = (EditText) findViewById(R.id.edtBillAmount);
        String message = editText.getText().toString();
        double tip = Double.parseDouble(message);
        tip = tip*0.12;
        View v = (CheckBox)findViewById(R.id.chkRound);
        String amount = "$"+String.valueOf(tip);
        if(boxCheck(v)){
            tip = (int)(tip);
            amount = "$"+tip;
        }
        TextView tv = (TextView)findViewById(R.id.txtTipResult);
        tv.setText("Tip: "+amount);
    }
}
