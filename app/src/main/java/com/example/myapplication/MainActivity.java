package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView timeToNewYear = findViewById(R.id.textViewMain);

        Calendar calendar = new GregorianCalendar(2025, 0, 1);
        Date today = Calendar.getInstance().getTime();
        Date nextYear = calendar.getTime();

        long todayMillis = today.getTime();
        long nextYearMillis = nextYear.getTime();

        long millisLeft = nextYearMillis - todayMillis;
        long daysLeft = TimeUnit.MILLISECONDS.toDays(millisLeft);

        millisLeft -= TimeUnit.DAYS.toMillis(daysLeft);

        long hoursLeft = TimeUnit.MILLISECONDS.toHours(millisLeft);

        millisLeft -= TimeUnit.HOURS.toMillis(hoursLeft);

        long minutesLeft = TimeUnit.MILLISECONDS.toMinutes(millisLeft);

        String textToDisplay = "До нового года осталось " + daysLeft + " дней, " + hoursLeft + " часов, " + minutesLeft + " минут";

        timeToNewYear.setText(textToDisplay);
    }
}