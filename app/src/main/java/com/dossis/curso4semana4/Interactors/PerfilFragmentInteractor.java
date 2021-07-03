package com.dossis.curso4semana4.Interactors;

import android.content.Context;

import com.dossis.curso4semana4.R;
import com.dossis.curso4semana4.adapter.MascotaAdapter;
import com.dossis.curso4semana4.interfaces.IPerfilFragmentInteractor;
import com.dossis.curso4semana4.pojo.Mascota;
import com.dossis.curso4semana4.presenter.PerfilFragmentPresenter;
import com.dossis.curso4semana4.restApi.IGRetrofit;
import com.dossis.curso4semana4.restApi.Keys;

import java.util.ArrayList;

public class PerfilFragmentInteractor implements IPerfilFragmentInteractor {


    PerfilFragmentPresenter perfilFragmentPresenter;
    Context context;
    Mascota miMascotaPerfil;
    ArrayList<Mascota> fotosPerfil;
    MascotaAdapter adapter;

    public PerfilFragmentInteractor(PerfilFragmentPresenter perfilFragmentPresenter, Context context) {
        this.perfilFragmentPresenter = perfilFragmentPresenter;
        this.context = context;
    }

    @Override
    public void crearAdapter() {
        fotosPerfil = new ArrayList<>();
        IGRetrofit igRetrofit = new IGRetrofit(context);
        adapter = new MascotaAdapter(getMascotasPerfilInstagram(), false, true, context);
        //El adaptador y las fotos se actualizarán mas tarde cuando termine la consulta.
        igRetrofit.callMedia(adapter, fotosPerfil);
        resultAdapter(adapter);

    }

    @Override
    public void resultAdapter(MascotaAdapter adapter) {
        this.perfilFragmentPresenter.resultAdapter(adapter);
    }

    private ArrayList<Mascota> getMascotasPerfilInstagram() {
        return fotosPerfil;
    }

    @Override
    public void crearMascotaPerfilFake() {

        //Pongo una cualquiera fija
        miMascotaPerfil = new Mascota();
        miMascotaPerfil.setIdFoto(R.drawable.coursera);
        miMascotaPerfil.setNombre(Keys.ACTIVE_USER_NAME);
        miMascotaPerfil.setUrl(null);

        getMascotaPerfil(miMascotaPerfil);
    }

    @Override
    public void getMascotaPerfil(Mascota mascota) {
        perfilFragmentPresenter.getMascotaPerfil(mascota);
    }


}
