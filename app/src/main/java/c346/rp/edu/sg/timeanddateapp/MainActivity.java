package c346.rp.edu.sg.timeanddateapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;

    Button displayDateBtn, displayTimeBtn, resetBtn;

    TextView displayTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        displayDateBtn = findViewById(R.id.displayDateBtn);
        displayTimeBtn = findViewById(R.id.displayTimeBtn);
        resetBtn = findViewById(R.id.resetBtn);

        displayTv = findViewById(R.id.displayTv);

        displayTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Time is ";
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                String time = hour + ":" + min;
                message += time;

                displayTv.setText(message);
            }
        });

        displayDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Date is ";
                int day = dp.getDayOfMonth();
                int mth = dp.getMonth();
                int year = dp.getYear();

                String date = day+"/"+(mth+1)+"/"+year;
                message += date;

                displayTv.setText(message);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setIs24HourView(false);
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2019, 1, 1);
            }
        });

    }
}
