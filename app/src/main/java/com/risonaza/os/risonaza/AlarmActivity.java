package com.risonaza.os.risonaza;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    Button setalarmbutton;
    CheckBox hackcheck,codecheck,techquizcheck,graphiccheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        hackcheck=(CheckBox)findViewById(R.id.hackcheck);
        codecheck=(CheckBox)findViewById(R.id.codecheck);
        techquizcheck=(CheckBox)findViewById(R.id.Quizcheck);
        graphiccheck=(CheckBox)findViewById(R.id.graficocheck);

        setalarmbutton=(Button)findViewById(R.id.setalarmbutton);
        setalarmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();

                if (hackcheck.isChecked())
                {
                    if(Build.VERSION.SDK_INT>=23) {
                        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 14, 10, 35, 0);
                    }
                    else
                    {
                        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 14, 10, 35, 0);
                        Toast.makeText(AlarmActivity.this, ""+calendar.get(Calendar.YEAR), Toast.LENGTH_SHORT).show();
                    }
                    setAlarm(calendar.getTimeInMillis());

                }
                if (codecheck.isChecked())
                {

                    if(Build.VERSION.SDK_INT>=23) {
                        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 15, 12, 35, 0);
                    }
                    else
                    {
                        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 15, 12, 35, 0);
                        Toast.makeText(AlarmActivity.this, ""+calendar.get(Calendar.YEAR), Toast.LENGTH_SHORT).show();
                    }
                    setAlarm(calendar.getTimeInMillis());

                }
                if (techquizcheck.isChecked())
                {

                    if(Build.VERSION.SDK_INT>=23) {
                        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 14, 1, 35, 0);
                    }
                    else
                    {
                        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 14, 1, 35, 0);
                        Toast.makeText(AlarmActivity.this, ""+calendar.get(Calendar.YEAR), Toast.LENGTH_SHORT).show();
                    }
                    setAlarm(calendar.getTimeInMillis());

                }
                if (graphiccheck.isChecked())
                {

                    if(Build.VERSION.SDK_INT>=23) {
                        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),13, 9, 30, 0);
                    }
                    else
                    {
                        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 13, 9, 30, 0);
                        Toast.makeText(AlarmActivity.this, ""+calendar.get(Calendar.YEAR), Toast.LENGTH_SHORT).show();
                    }
                    setAlarm(calendar.getTimeInMillis());

                }
            }
        });
    }

    private void setAlarm(long timeInMillis) {
        AlarmManager manager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);

        Intent intent=new Intent(AlarmActivity.this,MyAlarm.class);

        PendingIntent pendingIntent=PendingIntent.getBroadcast(AlarmActivity.this,0,intent,0);
        manager.setRepeating(AlarmManager.RTC,timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(this, "alarm set"+timeInMillis, Toast.LENGTH_SHORT).show();
    }
}
