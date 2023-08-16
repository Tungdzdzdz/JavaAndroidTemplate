package com.hfad.templateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        String string = String.format(getIntent().getStringExtra("Group") + " " + getIntent().getStringExtra("Child"));
        TextView textView =findViewById(R.id.textview_id);
        textView.setText(string);
    }
}