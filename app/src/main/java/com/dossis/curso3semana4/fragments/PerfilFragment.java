package com.dossis.curso3semana4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dossis.curso3semana4.R;
import com.dossis.curso3semana4.adapter.MascotaAdapter;
import com.dossis.curso3semana4.models.Mascota;

import java.util.ArrayList;

import static com.dossis.curso3semana4.fragments.RecyclerviewFragment.mascotasVotacion;

public class PerfilFragment extends Fragment {

    public static ArrayList fotosPerfil;
    private RecyclerView rvPerfil;

    public PerfilFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        View layout = v.findViewById(R.id.layoutPerritoContainer);
        Mascota miMascota = (Mascota) mascotasVotacion.get(0);

        ImageView imgHuesoBlanco = layout.findViewById(R.id.imgHuesoBlanco);
        imgHuesoBlanco.setVisibility(View.GONE);

        ImageView imgHuesoAmarillo = layout.findViewById(R.id.imgHuestoAmarillo);
        imgHuesoAmarillo.setVisibility(View.GONE);

        TextView tvLikes = layout.findViewById(R.id.tvContadorLikes);
        tvLikes.setVisibility(View.GONE);

        TextView tvNombre = layout.findViewById(R.id.tvNombre);
        tvNombre.setText(miMascota.getNombre());

        ImageView imgFoto = layout.findViewById(R.id.imgFoto);
        imgFoto.setImageResource(miMascota.getIdFoto());

        crearArrayMascotas();
        asociarRecyclerView(v);
        inicializarAdapter();

        return v;
    }

    private void crearArrayMascotas() {
        if (fotosPerfil == null) {
            fotosPerfil = new ArrayList<Mascota>();
            fotosPerfil.add(new Mascota(1, "Rufo", 11, R.drawable.perro1));
            fotosPerfil.add(new Mascota(2, "", 13, R.drawable.perro1));
            fotosPerfil.add(new Mascota(3, "", 7, R.drawable.perro1));
            fotosPerfil.add(new Mascota(4, "", 6, R.drawable.perro1));
            fotosPerfil.add(new Mascota(5, "", 4, R.drawable.perro1));
            fotosPerfil.add(new Mascota(6, "", 8, R.drawable.perro1));
            fotosPerfil.add(new Mascota(7, "", 10, R.drawable.perro1));
            fotosPerfil.add(new Mascota(8, "", 21, R.drawable.perro1));
        }

    }

    private void asociarRecyclerView(View v) {
        rvPerfil = v.findViewById(R.id.rvPerfil);
        GridLayoutManager glm = new GridLayoutManager(v.getContext(), 2);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPerfil.setLayoutManager(glm);
    }

    private void inicializarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(fotosPerfil, false, true);
        rvPerfil.setAdapter(adapter);
    }
}