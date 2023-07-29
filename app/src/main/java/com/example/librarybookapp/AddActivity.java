package com.example.librarybookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.librarybookapp.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {


    ActivityAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.name.getText().toString();
                String author = binding.author.getText().toString();
                int pNumber = Integer.parseInt(binding.pNumber.getText().toString().trim());

                DBHelper db = new DBHelper(AddActivity.this);
                db.addBooks(AddActivity.this, name, author, pNumber);
            }
        });
    }
}