package com.ricardohg.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewItemActivity extends AppCompatActivity implements View.OnClickListener{

    // Buttons:
    FloatingActionButton btnAccept;

    // Text entries:
    EditText etTitle, etDeveloper, etPublisher, etPlatform, etRelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        // UI SEARCH
        // Text entries:
        etTitle = findViewById(R.id.etTitle);
        etDeveloper = findViewById(R.id.etDeveloper);
        etPublisher = findViewById(R.id.etPublisher);
        etPlatform = findViewById(R.id.etPlatform);
        etRelease = findViewById(R.id.etRelease);

        // Buttons:
        btnAccept = findViewById(R.id.btnAccept);

        btnAccept.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAccept:
                //Log.d("Mensaje: ", "Click detectado");
                Intent intent = new Intent();
                Videogame newGame = new Videogame(
                        etTitle.getText().toString(),
                        etDeveloper.getText().toString(),
                        etPublisher.getText().toString(),
                        etPlatform.getText().toString(),
                        etRelease.getText().toString());

                intent.putExtra("newGame", newGame);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
