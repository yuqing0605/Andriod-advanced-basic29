package com.example.basic29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3;

    SharedPreferences data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editTextTextPersonName1);
        et2 = findViewById(R.id.editTextTextPersonName2);
        et3 = findViewById(R.id.editTextTextPersonName3);
    }

    public void save(View view){
        data = getSharedPreferences("set", MODE_PRIVATE);
        data.edit().putString("Name", et1.getText().toString())
                .putString("phonenumber", et2.getText().toString())
                .putString("gender", et3.getText().toString())
                .apply();
    }

    public void clear(View view){
        et1.setText(null);
        et2.setText(null);
        et3.setText(null);
    }

    public void read(View view){
        data = getSharedPreferences("set", 0);
        et1.setText(data.getString("Name", ""));
        et2.setText(data.getString("phonenumber", ""));
        et3.setText(data.getString("gender", ""));
    }

}