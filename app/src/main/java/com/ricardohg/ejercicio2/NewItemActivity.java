package com.ricardohg.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Console;
import java.util.ArrayList;
import java.util.Calendar;

public class NewItemActivity<ListArray> extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    // Buttons:
    FloatingActionButton btnAccept;

    // Text entries:
    EditText etTitle, etPublisher;
    Spinner spPlatform, spDate;

    // String categories:
    ArrayList<String> categories = new ArrayList<String>();

    // Years for spinner:
    int startYear = 1958;
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    ArrayList<Integer> years = new ArrayList<Integer>();
    ArrayAdapter<String> dataAdapter;
    ArrayAdapter<Integer> yearAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        // Spinner default entries for spPlatform:
        categories.add("Switch");
        categories.add("Xbox One");
        categories.add("PS4");
        //categories.add(getString(R.string.customPlatform));

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
    }

    public ArrayList<Integer> getYears(){
        ArrayList<Integer> years = new ArrayList<Integer>();
        for(int i=currentYear; i>=startYear; i--){
            years.add(i);
        }
        return years;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAccept:
                //Log.i("Error", "Entra aqui");
                if(validateData()) {
                    //Log.d("Mensaje: ", "Click detectado");
                    Intent intent = new Intent();
                    Videogame newGame = new Videogame(
                            etTitle.getText().toString(),
                            etPublisher.getText().toString(),
                            spPlatform.getSelectedItem().toString(),
                            spDate.getSelectedItem().toString());

                    intent.putExtra("newGame", newGame);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting spinner item:
        String item = parent.getItemAtPosition(position).toString();

        // Show selected item:
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public Boolean validateData() {
        if(etTitle.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), getText(R.string.fail_name), Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(etPublisher.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), getText(R.string.fail_publisher), Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(spPlatform.getSelectedItem().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), getText(R.string.fail_platform), Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(spDate.getSelectedItem().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), getText(R.string.fail_release), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
