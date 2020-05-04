package com.ricardohg.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditItemActivity extends NewItemActivity {

    Videogame originalGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        originalGame = (Videogame) getIntent().getSerializableExtra("auxGame");
        //Toast.makeText(getApplicationContext(), Integer.toString(originalGame.getId()), Toast.LENGTH_SHORT).show();

        // Spinner entries for spYear;
        years = getYears();

        // UI SEARCH
        // Text entries:
        etTitle = findViewById(R.id.etTitle);
        etPublisher = findViewById(R.id.etPublisher);

        // Spinner entry:
        spPlatform = findViewById(R.id.spPlatform);
        spDate = findViewById(R.id.spDate);

        // Buttons:
        btnAccept = findViewById(R.id.btnAccept);

        // Button listeners:
        btnAccept.setOnClickListener(this);

        // Spinner config:
        // Adapter platform:
        dataAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                categories);
        // Adapter year;
        yearAdapter = new ArrayAdapter<Integer>(
                this,
                android.R.layout.simple_spinner_item,
                years);

        // Style: Drop down-list view with radio button:
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Attaching data adapter to spinner (platform):
        spPlatform.setAdapter(dataAdapter);

        // Attaching data adapter to spinner (years):
        spDate.setAdapter(yearAdapter);

        etTitle.setText(originalGame.getTitle());
        etPublisher.setText(originalGame.getPublisher());
        spPlatform.setSelection(dataAdapter.getPosition(originalGame.getPlatform()));
        //Log.i("Mensaje", auxGame.getReleaseDate());
        spDate.setSelection(yearAdapter.getPosition(Integer.parseInt(originalGame.getReleaseDate())));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAccept:
                //Log.i("Error", "Entra aqui");
                if(validateData()) {
                    Log.d("Mensaje: ", "Click detectado");
                    Intent intent = new Intent();
                    Videogame auxGame = new Videogame(
                            etTitle.getText().toString(),
                            etPublisher.getText().toString(),
                            spPlatform.getSelectedItem().toString(),
                            spDate.getSelectedItem().toString());

                    auxGame.setId(originalGame.getId());

                    Bundle extras = new Bundle();
                    extras.putSerializable("auxGame", auxGame);
                    extras.putSerializable("originalGame", originalGame);
                    intent.putExtras(extras);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;
        }
    }
}
