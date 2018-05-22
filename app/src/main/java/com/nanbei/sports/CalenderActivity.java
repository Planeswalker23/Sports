package com.nanbei.sports;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.DatePicker;
import android.widget.Toast;

public class CalenderActivity extends Activity{
    public int year;
    public int month;
    public int dayOfMonth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        //日历控件
        DatePickerDialog dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int iyear, int monthOfYear, int dayOfMonth) {
                long maxDate = datePicker.getMaxDate();//日历最大能设置的时间的毫秒值
                year = datePicker.getYear();//年
                month = datePicker.getMonth();//月-1
                dayOfMonth1 = datePicker.getDayOfMonth();//日
            }
        }, 2018, 4, 22);
        dp.show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //回传数据
                Intent data = new Intent();
                data.putExtra("year", year);
                data.putExtra("month", month+1);
                data.putExtra("day", dayOfMonth1);
                setResult(2, data);
                finish();
            }
        },3*1000);
    }
}
