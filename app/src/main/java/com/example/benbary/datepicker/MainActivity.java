package com.example.benbary.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btn;
    int  day;
    int  month;
    int  year;
    DatePickerDialog pickerDialog;
    static final int Dilog_id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Dilog_id);

              /* Toast.makeText(getApplicationContext(),
                       "gdddd",Toast.LENGTH_LONG).show();*/
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id ){
        if (id == Dilog_id)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                pickerDialog =new DatePickerDialog(this, dpickerlistner ,year ,month,day);
                pickerDialog.getDatePicker().setMaxDate(new Date().getTime());
            }
            return pickerDialog;
        }
        return  null;
    }
    private DatePickerDialog.OnDateSetListener dpickerlistner
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year1, int monthOfYear, int dayOfMonth) {
            year = year1;
            month = monthOfYear;
            day = dayOfMonth;
            Toast.makeText(MainActivity.this,year + "/"+month+"/"+day,Toast.LENGTH_LONG).show();

        }
    };
}
