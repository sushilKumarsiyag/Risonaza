package com.risonaza.os.risonaza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SportsSchedualActivity extends AppCompatActivity {

    ListView listView;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    ProgressBar progressBar;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_schedual);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");

        if (name.equals("cricket"))
        {
            ref = FirebaseDatabase.getInstance().getReference().child("Question");
            firebasedatatakecode();

        }

    }

    private void firebasedatatakecode() {
        list = new ArrayList<>();

    }
}
