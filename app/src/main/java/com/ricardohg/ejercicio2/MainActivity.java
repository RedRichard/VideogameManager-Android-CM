package com.ricardohg.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    ArrayList<Videogame> dataList;
    RecyclerView itemListRV;
    FloatingActionButton btnAddItem;
    AdapterListItem adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI search:
        // RecycleView:
        itemListRV = findViewById(R.id.itemListRV);
        itemListRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // Buttons:
        btnAddItem = findViewById(R.id.btnAddItem);

        //------------------------------------------
        // Data test generation:
        //dataList = new ArrayList<Videogame>();
        /*for(int i=0; i<=50; i++){
            Videogame game = new Videogame("Videojuego " + i, "Developer", "Publisher", "Platform", "Date");
            dataList.add(game);
        }*/
        //-----------------------------------------

        //Paper.book().write("videogames", dataList);

        // Database initialization:
        Paper.init(getApplicationContext());
        Paper.book().destroy();
        // Get data from database:
        dataList = ReadDatabaseVideogames();

        adapter = new AdapterListItem(dataList);

        itemListRV.setAdapter(adapter);

        // On click button:
        btnAddItem.setOnClickListener(this);

        // On click recycleview:
        //itemListRV.addOnItemTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAddItem:
                //Log.d("Mensaje: ", "Click detectado");
                Intent intent = new Intent(MainActivity.this, NewItemActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                Videogame newGame = (Videogame) data.getSerializableExtra("newGame");
                assert newGame != null;
                newGame.setId(dataList.size()+1);
                //Toast.makeText(getApplicationContext(), Integer.toString(newGame.getId()), Toast.LENGTH_SHORT).show();
                dataList.add(newGame);
                // Notify Database has changed to Paper:
                adapter.notifyDataSetChanged();
                SaveVideogamesToDatabase();
            }
        }
        if (requestCode == 2){
            if (resultCode == RESULT_OK){
                Bundle extras = data.getExtras();
                Videogame auxGame = (Videogame) extras.getSerializable("auxGame");
                //Videogame originalGame = (Videogame) extras.getSerializable("originalGame");

                /*int auxPos = dataList.indexOf(originalGame);
                Toast.makeText(getApplicationContext(), Integer.toString(auxPos), Toast.LENGTH_SHORT).show();*/

                dataList.set(auxGame.getId()-1, auxGame);
                adapter.notifyDataSetChanged();
                SaveVideogamesToDatabase();

                //Toast.makeText(getApplicationContext(), Integer.toString(auxGame.getId()-1), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public ArrayList<Videogame> ReadDatabaseVideogames(){
        return Paper.book().read("videogames", new ArrayList<Videogame>());
    }

    public void SaveVideogamesToDatabase(){
        Paper.book().write("videogames", dataList);
    }
}
