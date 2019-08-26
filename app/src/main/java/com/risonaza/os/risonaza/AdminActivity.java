package com.risonaza.os.risonaza;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    String gametype;
    EditText editText1,editText2,editTexttime,editText1date,editTextresult,editTextmatchno;
    Button btn;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);


        editText1=(EditText)findViewById(R.id.team1);
        editText2=(EditText)findViewById(R.id.team2);
        editTexttime=(EditText)findViewById(R.id.timing);
        editText1date=(EditText)findViewById(R.id.matchdate);
        editTextresult=(EditText)findViewById(R.id.result);
        editTextmatchno=(EditText)findViewById(R.id.matchno);
        btn=(Button)findViewById(R.id.submit);

        reference= FirebaseDatabase.getInstance().getReference();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            storevalidinfoforsports();
            }
        });

        List<String> categories = new ArrayList<String>();
        categories.add("Cricket");
        categories.add("Kabaddi");
        categories.add("Chess");
        categories.add("Football");
        categories.add("Carrom");
        categories.add("Table Tennis");
        categories.add("Volly Ball");
        categories.add("Badminton");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gametype = adapterView.getItemAtPosition(i).toString();
            }
        });
    }

    private void storevalidinfoforsports() {

        String team1=editText1.getText().toString();
        String team2=editText2.getText().toString();
        String timing=editTexttime.getText().toString();
        String date=editText1date.getText().toString();
        String result=editTextresult.getText().toString();
        String matchno=editTextmatchno.getText().toString();
        HashMap<String, Object> sportsteaminfo = new HashMap<>();

        sportsteaminfo.put("team1",team1);
        sportsteaminfo.put("team2",team2);
        sportsteaminfo.put("timing",timing);
        sportsteaminfo.put("date",date);
        sportsteaminfo.put("result",result);
        sportsteaminfo.put("matchno",matchno);
        reference.child("Cricket").child(matchno).updateChildren(sportsteaminfo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    editText1.setText("");
                    editText2.setText("");
                    editTexttime.setText("");
                    editText1date.setText("");
                    editTextresult.setText("");
                    editTextmatchno.setText("");
                    Toast.makeText(AdminActivity.this, "data has been inserted", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(AdminActivity.this, "data has not been inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
