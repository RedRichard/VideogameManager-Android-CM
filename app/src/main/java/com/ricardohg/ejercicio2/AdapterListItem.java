package com.ricardohg.ejercicio2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListItem extends RecyclerView.Adapter<AdapterListItem.ViewHolderDatos> {

    ArrayList<Videogame> itemList;

    public AdapterListItem(ArrayList<Videogame> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public AdapterListItem.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new AdapterListItem.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListItem.ViewHolderDatos holder, int position) {
        holder.setItem(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView gameTitle, gamePublisher, gamePlatform, gameDate;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            gameTitle = (TextView) itemView.findViewById(R.id.gameTitle);
            gamePublisher = (TextView) itemView.findViewById(R.id.gamePublisher);
            gamePlatform = (TextView) itemView.findViewById(R.id.gamePlatform);
            gameDate = (TextView) itemView.findViewById(R.id.gameDate);
        }

        public void setItem(Videogame videogame) {
            gameTitle.setText(videogame.getTitle());
            gamePublisher.setText(videogame.getPublisher());
            gamePlatform.setText(videogame.getPlatform());
            gameDate.setText(videogame.getReleaseDate());
        }
    }
}
