package com.example.elegirfecha;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import java.util.Calendar;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btnDatePicker, btnTimePicker, btnSaveEvent;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        btnDatePicker = (Button) findViewById(R.id.btn_fecha);
        btnTimePicker = (Button) findViewById(R.id.btn_hora);
        btnSaveEvent = (Button) findViewById(R.id.btn_guardar);
        txtDate = (EditText) findViewById(R.id.input_fecha);
        txtTime = (EditText) findViewById(R.id.input_hora);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {

        if (v == btnDatePicker){
            //Tomar la fecha
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener(){

                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                            txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }

            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker){
            //Tomar la hora
            final Calendar c = Calendar.getInstance();

            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Lanzador del Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                            txtTime.setText(hourOfDay + ":"+minute);

                        }
            }, mHour, mMinute, false);

        timePickerDialog.show();
        }
        if (v == btnSaveEvent){
            //Guarda evento, o eso se supone
            Calendar cal = Calendar.getInstance();

            cal.set(Calendar.DAY_OF_MONTH, mDay);
            cal.set(Calendar.MONTH, mMonth);
            cal.set(Calendar.YEAR, mYear);

            cal.set(Calendar.HOUR_OF_DAY, mHour);
            cal.set(Calendar.MINUTE, mMinute);

            Intent intent = new Intent(Intent.ACTION_EDIT)
                .setType("vnd.android.cursor.item/event")
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis())
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis()+60*60*1000)
                    .putExtra(CalendarContract.Events.ALL_DAY, false)
                    .putExtra(CalendarContract.Events.RRULE , "FREQ=DAILY")
                    .putExtra(CalendarContract.Events.TITLE, "Título de vuestro evento")
                    .putExtra(CalendarContract.Events.DESCRIPTION, "Descripción")
                    .putExtra(CalendarContract.Events.EVENT_LOCATION,"Calle x");

            startActivity(intent);
            }
        }




}

