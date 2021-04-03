package com.dossis.curso3semana4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.dossis.curso3semana3.R;
import com.dossis.curso3semana4.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    boolean permitirLike = false;

    public MascotaAdapter(ArrayList<Mascota> mascotas, boolean permitirLike) {
        this.mascotas = mascotas;
        this.permitirLike = permitirLike;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Infla el layout y lo pasará al viewholder para que él obtenga los views
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        //Asocia cada elemento de la lista con cada view.
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getIdFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvContadorLikes.setText(String.valueOf(mascota.getLikes()));
        if (permitirLike) {
            mascotaViewHolder.imgHuesoBlanco.setVisibility(View.VISIBLE);
            mascotaViewHolder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mascota.addLike();
                    notifyDataSetChanged();
                }
            });
        } else {
            mascotaViewHolder.imgHuesoBlanco.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends ViewHolder {
        private ImageView imgFoto, imgHuesoBlanco, imgHuestoAmarillo;
        private TextView tvNombre, tvContadorLikes;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgHuesoBlanco = (ImageView) itemView.findViewById(R.id.imgHuesoBlanco);
            imgHuestoAmarillo = (ImageView) itemView.findViewById(R.id.imgHuestoAmarillo);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvContadorLikes = (TextView) itemView.findViewById(R.id.tvContadorLikes);
        }
    }

}
