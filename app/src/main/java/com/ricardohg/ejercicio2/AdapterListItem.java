package com.ricardohg.ejercicio2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListItem extends RecyclerView.Adapter<AdapterListItem.ViewHolderDatos> {

    // Videogame data:
    ArrayList<Videogame> itemList;

    // Image:
    ImageView platformImage;

    private int checkedPosition = 0;
    private Context context;
    private Activity currentActivity;

    public AdapterListItem(ArrayList<Videogame> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public AdapterListItem.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        context = parent.getContext();

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

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView gameTitle, gamePublisher, gamePlatform, gameDate;
        String gameId;
        Videogame auxGame;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            gameTitle = (TextView) itemView.findViewById(R.id.gameTitle);
            gamePublisher = (TextView) itemView.findViewById(R.id.gamePublisher);
            gamePlatform = (TextView) itemView.findViewById(R.id.gamePlatform);
            gameDate = (TextView) itemView.findViewById(R.id.gameDate);

            platformImage = (ImageView) itemView.findViewById(R.id.platformImage);

            itemView.setOnClickListener(this);
        }

        public void setItem(Videogame videogame) {
            auxGame = videogame;
            gameTitle.setText(videogame.getTitle());
            gamePublisher.setText(videogame.getPublisher());
            gamePlatform.setText(videogame.getPlatform());
            gameDate.setText(videogame.getReleaseDate());

            gameId = Integer.toString(videogame.getId());

            switch(videogame.getPlatform()){
                case "Switch":
                    platformImage.setImageDrawable(ContextCompat.getDrawable(platformImage.getContext(), R.drawable.switch_icon));
                    break;
                case "Xbox One":
                    platformImage.setImageDrawable(ContextCompat.getDrawable(platformImage.getContext(), R.drawable.xbox_icon));
                    break;
                case "PS4":
                    platformImage.setImageDrawable(ContextCompat.getDrawable(platformImage.getContext(), R.drawable.ps_icon));
                    break;
            }
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, context.getResources().getString(R.string.item_id_found) + " " + gameId, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, EditItemActivity.class);

            intent.putExtra("auxGame", auxGame);

            ((Activity) context).startActivityForResult(intent, 2);
            //context.startActivity(intent);
        }
    }
}
