package com.ricardohg.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Videogame> dataList;
    RecyclerView itemListRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemListRV = findViewById(R.id.itemListRV);
        itemListRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //------------------------------------------
        //DATOS
        /*dataList = new ArrayList<String>();

        for(int i=0; i<=50; i++){
            dataList.add("Dato #" + i);
        }*/
        dataList = new ArrayList<Videogame>();
        /*String[][] data = {
                {"Videojuego 1", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
                {"Videojuego 2", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
                {"Videojuego 3", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
                {"Videojuego 4", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
                {"Videojuego 5", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
                {"Videojuego 6", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
                {"Videojuego 7", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
                {"Videojuego 8", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
                {"Videojuego 9", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
                {"Videojuego 10", "Developer 1", "Publisher 1", "Platform 1", "Release Date"},
        };*/

        for(int i=0; i<=50; i++){
            Videogame game = new Videogame("Videojuego " + i, "Developer", "Publisher", "Platform", "Date");
            dataList.add(game);
        }
        //-----------------------------------------

        AdapterListItem adapter = new AdapterListItem(dataList);

        itemListRV.setAdapter(adapter);
    }
}
