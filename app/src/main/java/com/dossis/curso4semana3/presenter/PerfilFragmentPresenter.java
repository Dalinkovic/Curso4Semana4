package com.dossis.curso4semana3.presenter;

import com.dossis.curso4semana3.Interactors.PerfilFragmentInteractor;
import com.dossis.curso4semana3.adapter.MascotaAdapter;
import com.dossis.curso4semana3.fragments.PerfilFragmentView;
import com.dossis.curso4semana3.interfaces.IPerfilFragmentPresenter;
import com.dossis.curso4semana3.pojo.Mascota;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {
    PerfilFragmentView perfilFragmentView;
    PerfilFragmentInteractor perfilFragmentInteractor;

    public PerfilFragmentPresenter(PerfilFragmentView perfilFragmentView) {
        this.perfilFragmentView = perfilFragmentView;
        perfilFragmentInteractor = new PerfilFragmentInteractor(this, this.perfilFragmentView.getContext());

        perfilFragmentInteractor.crearMascotaPerfilFake();

    }

    @Override
    public void crearAdapter() {

        perfilFragmentInteractor.crearAdapter();

    }

    @Override
    public void resultAdapter(MascotaAdapter adapter) {
        perfilFragmentView.resultAdapter(adapter);
    }


    @Override
    public void getMascotaPerfil(Mascota mascota) {
        perfilFragmentView.getNombreMiMascota(mascota.getNombre());
        perfilFragmentView.getIdFotoMiMascota(mascota.getIdFoto());

    }


}
