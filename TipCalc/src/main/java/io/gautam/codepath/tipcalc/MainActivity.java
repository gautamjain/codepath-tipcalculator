package io.gautam.codepath.tipcalc;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    EditText etTotalAmount;
    TextView tvTipAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTotalAmount = (EditText) findViewById(R.id.tvTotalAmount);
        tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);

        etTotalAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(!s.toString().equals(current)){
//                    [your_edittext].removeTextChangedListener(this);
//
//                    String cleanString = s.toString().replaceAll("[$,.]", "");
//
//                    double parsed = Double.parseDouble(cleanString);
//                    String formated = NumberFormat.getCurrencyInstance().format((parsed/100));
//
//                    current = formated;
//                    [your_edittext].setText(formated);
//                    [your_edittext].setSelection(formated.length());
//
//                    [your_edittext].addTextChangedListener(this);
//                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onTip(View view) {

        double tipPercent = 0;

        switch (view.getId()) {
            case R.id.btn_ten_percent:
                tipPercent = 0.10;
                break;
            case R.id.btn_fifteen_percent:
                tipPercent = 0.15;
                break;
            case R.id.btn_twenty_percent:
                tipPercent = 0.20;
                break;
        }

        // Calculate tip
        double tip = tipPercent * Double.valueOf(etTotalAmount.getText().toString());

        // Format and display
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        tvTipAmount.setText(formatter.format(tip));
    }

}
