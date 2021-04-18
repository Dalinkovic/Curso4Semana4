package com.dossis.curso3semana5.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dossis.curso3semana5.R;
import com.dossis.curso3semana5.adapter.MascotaAdapter;
import com.dossis.curso3semana5.database.*;

import java.util.ArrayList;

public class RecyclerviewFragment extends Fragment
{
    public  ArrayList mascotasVotacion;
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


     TablaMascotas tablaMascotas= new TablaMascotas();
        mascotasVotacion= tablaMascotas.getMascotasOrderedId(getContext());


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
