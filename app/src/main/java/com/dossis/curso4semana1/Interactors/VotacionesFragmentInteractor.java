package com.dossis.curso4semana1.Interactors;

import android.content.Context;

import com.dossis.curso4semana1.adapter.MascotaAdapter;
import com.dossis.curso4semana1.interfaces.IVotacionesFragmentInteractor;
import com.dossis.curso4semana1.pojo.Mascota;
import com.dossis.curso4semana1.presenter.VotacionesFragmentPresenter;
import com.dossis.curso4semana1.database.*;
import java.util.ArrayList;

public class VotacionesFragmentInteractor implements IVotacionesFragmentInteractor {
    VotacionesFragmentPresenter votacionesFragmentPresenter;
Context context;

    public VotacionesFragmentInteractor(VotacionesFragmentPresenter votacionesFragmentPresenter, Context context) {
        this.votacionesFragmentPresenter = votacionesFragmentPresenter;
        this.context= context;
    }

    @Override
    public void crearAdapter() {

        MascotaAdapter adapter = new MascotaAdapter(getArrayMascotas(), true, false);
        resultAdapter(adapter);
    }

    private ArrayList<Mascota> getArrayMascotas() {
        TablaMascotas tablaMascotas = new TablaMascotas();
        ArrayList<Mascota>  resultado = tablaMascotas.getMascotasOrderedId(this.context);
        return resultado;
    }
    @Override
    public void resultAdapter(MascotaAdapter adapter) {
        votacionesFragmentPresenter.resultAdapter(adapter);
    }
}


