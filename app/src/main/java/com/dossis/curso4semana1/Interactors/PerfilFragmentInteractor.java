package com.dossis.curso4semana1.Interactors;

import android.content.Context;

import com.dossis.curso4semana1.R;
import com.dossis.curso4semana1.adapter.MascotaAdapter;
import com.dossis.curso4semana1.interfaces.IPerfilFragmentInteractor;
import com.dossis.curso4semana1.pojo.Mascota;
import com.dossis.curso4semana1.presenter.PerfilFragmentPresenter;
import com.dossis.curso4semana1.database.*;

import java.util.ArrayList;

public class PerfilFragmentInteractor implements IPerfilFragmentInteractor {


    PerfilFragmentPresenter perfilFragmentPresenter;
    Context context;
    Mascota miMascotaPerfil;

    public PerfilFragmentInteractor(PerfilFragmentPresenter perfilFragmentPresenter, Context context) {
        this.perfilFragmentPresenter = perfilFragmentPresenter;
        this.context = context;
    }

    @Override
    public void crearAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(crearArrayMascotas(), false, true);

        resultAdapter(adapter);
    }

    @Override
    public void resultAdapter(MascotaAdapter adapter) {
        this.perfilFragmentPresenter.resultAdapter(adapter);
    }

    private ArrayList<Mascota> crearArrayMascotas() {

        ArrayList<Mascota>    fotosPerfil = new ArrayList<Mascota>();
            fotosPerfil.add(new Mascota(1, "Rufo", 11, R.drawable.perro1));
            fotosPerfil.add(new Mascota(2, "", 13, R.drawable.perro1));
            fotosPerfil.add(new Mascota(3, "", 7, R.drawable.perro1));
            fotosPerfil.add(new Mascota(4, "", 6, R.drawable.perro1));
            fotosPerfil.add(new Mascota(5, "", 4, R.drawable.perro1));
            fotosPerfil.add(new Mascota(6, "", 8, R.drawable.perro1));
            fotosPerfil.add(new Mascota(7, "", 10, R.drawable.perro1));
            fotosPerfil.add(new Mascota(8, "", 21, R.drawable.perro1));


        return fotosPerfil;
    }

    @Override
    public  void crearMascotaPerfilFake()
    {
        //Obtengo el primero de la lista ordenada por ID y ese será nuestra mascota del perfil.
        TablaMascotas tablaMascotas=new TablaMascotas();
        ArrayList<Mascota> mascotasVotacion = tablaMascotas.getMascotasOrderedId(this.context);
        miMascotaPerfil = (Mascota) mascotasVotacion.get(0);
        getMascotaPerfil(miMascotaPerfil);
    }
    @Override
    public void getMascotaPerfil(Mascota mascota)
    {
        perfilFragmentPresenter.getMascotaPerfil(mascota);
    }

}
