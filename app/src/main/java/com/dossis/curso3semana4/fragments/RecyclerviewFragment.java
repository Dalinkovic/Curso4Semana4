package com.dossis.curso3semana4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dossis.curso3semana4.R;
import com.dossis.curso3semana4.adapter.MascotaAdapter;
import com.dossis.curso3semana4.models.Mascota;

import java.util.ArrayList;

public class RecyclerviewFragment extends Fragment
{
    public static ArrayList mascotasVotacion;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);
          crearArrayMascotas();
        asociarRecyclerView(v);
        inicializarAdapter();

        return v;
    }

    private void crearArrayMascotas() {
        if (mascotasVotacion == null) {
            mascotasVotacion = new ArrayList<Mascota>();
            mascotasVotacion.add(new Mascota(1, "Rufo", 0, R.drawable.perro1));
            mascotasVotacion.add(new Mascota(2, "Chicho", 0, R.drawable.perro2));
            mascotasVotacion.add(new Mascota(3, "Luisma", 0, R.drawable.perro3));
            mascotasVotacion.add(new Mascota(4, "Baraja", 0, R.drawable.perro4));
            mascotasVotacion.add(new Mascota(5, "Rajoy", 0, R.drawable.perro5));
            mascotasVotacion.add(new Mascota(6, "Mourinho", 0, R.drawable.perro6));
            mascotasVotacion.add(new Mascota(7, "Ojopipa", 0, R.drawable.perro7));
            mascotasVotacion.add(new Mascota(8, "Carahuevo", 0, R.drawable.perro8));
        }

    }

    private void asociarRecyclerView(View v) {
        rvMascotas = v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(v.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    private void inicializarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(mascotasVotacion, true,false);
        rvMascotas.setAdapter(adapter);
    }
}
