package com.dossis.curso4semana3.presenter;

import com.dossis.curso4semana3.Interactors.VotacionesFragmentInteractor;
import com.dossis.curso4semana3.adapter.MascotaAdapter;
import com.dossis.curso4semana3.fragments.VotacionesFragmentView;
import com.dossis.curso4semana3.interfaces.IVotacionesFragmentPresenter;

public class VotacionesFragmentPresenter implements IVotacionesFragmentPresenter {


    VotacionesFragmentView votacionesFragmentView;
    VotacionesFragmentInteractor votacionesFragmentInteractor;

    public VotacionesFragmentPresenter(VotacionesFragmentView votacionesFragmentView) {
        this.votacionesFragmentView = votacionesFragmentView;
        votacionesFragmentInteractor = new VotacionesFragmentInteractor(this, this.votacionesFragmentView.getContext());
    }


    @Override
    public void crearAdapter() {
        votacionesFragmentInteractor.crearAdapter();
    }


    @Override
    public void resultAdapter(MascotaAdapter adapter) {
        votacionesFragmentView.resultAdapter(adapter);
    }
}
