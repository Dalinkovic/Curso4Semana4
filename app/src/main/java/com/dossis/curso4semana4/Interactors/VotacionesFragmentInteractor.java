package com.dossis.curso4semana4.Interactors;

import android.content.Context;

import com.dossis.curso4semana4.adapter.MascotaAdapter;
import com.dossis.curso4semana4.database.TablaMascotas;
import com.dossis.curso4semana4.interfaces.IVotacionesFragmentInteractor;
import com.dossis.curso4semana4.pojo.Mascota;
import com.dossis.curso4semana4.presenter.VotacionesFragmentPresenter;

import java.util.ArrayList;

public class VotacionesFragmentInteractor implements IVotacionesFragmentInteractor {
    VotacionesFragmentPresenter votacionesFragmentPresenter;
    Context context;

    public VotacionesFragmentInteractor(VotacionesFragmentPresenter votacionesFragmentPresenter, Context context) {
        this.votacionesFragmentPresenter = votacionesFragmentPresenter;
        this.context = context;
    }

    @Override
    public void crearAdapter() {

        MascotaAdapter adapter = new MascotaAdapter(getArrayMascotas(), true, false, this.context);
        resultAdapter(adapter);
    }

    private ArrayList<Mascota> getArrayMascotas() {
        TablaMascotas tablaMascotas = new TablaMascotas(context);
        ArrayList<Mascota> resultado = tablaMascotas.getMascotasOrderedId(this.context);
        return resultado;
    }

    @Override
    public void resultAdapter(MascotaAdapter adapter) {
        votacionesFragmentPresenter.resultAdapter(adapter);
    }
}


