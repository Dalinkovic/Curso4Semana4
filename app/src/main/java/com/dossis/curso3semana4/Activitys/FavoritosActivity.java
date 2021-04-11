package com.dossis.curso3semana4.Activitys;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dossis.curso3semana4.Adapter.MascotaAdapter;
import com.dossis.curso3semana4.R;

import java.util.ArrayList;
import java.util.Collections;

import static com.dossis.curso3semana4.RecyclerviewFragment.mascotasVotacion;


public class FavoritosActivity extends BaseActivity {

    public ArrayList mascotasOrdenadas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        if (toolbar==null) {setActionBar(this,true);}

        crearArrayMascotas();
        asociarRecyclerView();
        inicializarAdapter();

    }


    private void crearArrayMascotas() {
        mascotasOrdenadas = (ArrayList) mascotasVotacion.clone();
        Collections.sort(mascotasOrdenadas);
        mascotasOrdenadas.subList(5, mascotasOrdenadas.size()).clear();
    }

    private void asociarRecyclerView() {
        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    private void inicializarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(mascotasOrdenadas,false,false);
        rvMascotas.setAdapter(adapter);

    }
}