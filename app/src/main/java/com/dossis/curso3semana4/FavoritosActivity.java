package com.dossis.curso3semana4;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dossis.curso3semana4.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import static com.dossis.curso3semana4.MainActivity.mascotas;

public class FavoritosActivity extends BaseActivity {

    public ArrayList mascotasOrdenadas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        setActionBar(this,true);

        crearArrayMascotas();
        asociarRecyclerView();
        inicializarAdapter();

    }


    private void crearArrayMascotas() {
        mascotasOrdenadas = (ArrayList) mascotas.clone();
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
        MascotaAdapter adapter = new MascotaAdapter(mascotasOrdenadas,false);
        rvMascotas.setAdapter(adapter);

    }
}