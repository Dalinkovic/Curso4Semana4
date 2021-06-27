package com.dossis.curso4semana3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.dossis.curso4semana3.R;
import com.dossis.curso4semana3.database.TablaMascotas;
import com.dossis.curso4semana3.pojo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    Context context;
    ArrayList<Mascota> mascotas;
    boolean permitirLike;
    boolean versionReducida;


    public MascotaAdapter(ArrayList<Mascota> mascotas, boolean permitirLike, boolean versionReducida, Context context) {

        this.context = context;
        this.mascotas = mascotas;
        this.permitirLike = permitirLike;
        this.versionReducida = versionReducida;

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
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvContadorLikes.setText(String.valueOf(mascota.getLikes()));

        //Uso el mismo adaptador para todos los recyclers.
        //Si tiene URL es de el fragment de perfil.
        if (mascota.getUrl() != null) {
            Picasso.with(context)
                    .load(mascota.getUrl())
                    .placeholder(R.drawable.huella)
                    .into(mascotaViewHolder.imgFoto);
        } else {
            mascotaViewHolder.imgFoto.setImageResource(mascota.getIdFoto());
        }


        if (permitirLike) {
            mascotaViewHolder.imgHuesoBlanco.setVisibility(View.VISIBLE);
            mascotaViewHolder.imgHuesoBlanco.setOnClickListener(v -> {

                TablaMascotas tablaMascotas = new TablaMascotas(v.getContext());
                tablaMascotas.addLike(v.getContext(), mascota.getId());
                mascotas = tablaMascotas.getMascotasOrderedId(v.getContext());
                notifyDataSetChanged();

            });
        } else {
            mascotaViewHolder.imgHuesoBlanco.setVisibility(View.INVISIBLE);
        }
        if (versionReducida) {
            mascotaViewHolder.tvNombreMascota.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if (mascotas == null) {
            return 0;
        } else {
            return mascotas.size();
        }
    }

    public static class MascotaViewHolder extends ViewHolder {
        private final ImageView imgFoto;
        private final ImageView imgHuesoBlanco;
        private final TextView tvNombreMascota;
        private final TextView tvContadorLikes;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            imgHuesoBlanco = itemView.findViewById(R.id.imgHuesoBlanco);
            tvNombreMascota = itemView.findViewById(R.id.tvNombreMascota);
            tvContadorLikes = itemView.findViewById(R.id.tvContadorLikes);
        }
    }

}
