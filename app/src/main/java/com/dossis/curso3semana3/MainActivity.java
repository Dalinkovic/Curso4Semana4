package com.dossis.curso3semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dossis.curso3semana3.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crearArrayMascotas();
        asociarRecyclerView();
        inicializarAdapter();
    }

    private void crearArrayMascotas()
    {
        mascotas= new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,"Rufo",0,R.drawable.perro1));
        mascotas.add(new Mascota(2,"Chicho",0,R.drawable.perro2));
        mascotas.add(new Mascota(3,"Luisma",0,R.drawable.perro3));
        mascotas.add(new Mascota(4,"Baraja",0,R.drawable.perro4));
        mascotas.add(new Mascota(5,"Rajoy",0,R.drawable.perro5));
        mascotas.add(new Mascota(6,"Mourinho",0,R.drawable.perro6));
        mascotas.add(new Mascota(7,"Ojopipa",0,R.drawable.perro7));
        mascotas.add(new Mascota(8,"Carahuevo",0,R.drawable.perro8));

    }

    private void asociarRecyclerView(){
        rvMascotas=(RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this,2);

        rvMascotas.setLayoutManager(llm);
    }
    private void inicializarAdapter(){
        MascotaAdapter adapter= new MascotaAdapter(mascotas);
        rvMascotas.setAdapter(adapter);

    }
}