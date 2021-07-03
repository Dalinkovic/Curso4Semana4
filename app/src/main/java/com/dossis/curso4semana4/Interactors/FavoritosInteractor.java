package com.dossis.curso4semana4.Interactors;

import android.content.Context;

import com.dossis.curso4semana4.adapter.MascotaAdapter;
import com.dossis.curso4semana4.database.TablaMascotas;
import com.dossis.curso4semana4.interfaces.IFavoritosInteractor;
import com.dossis.curso4semana4.pojo.Mascota;
import com.dossis.curso4semana4.presenter.FavoritosPresenter;

import java.util.ArrayList;

public class FavoritosInteractor implements IFavoritosInteractor {
    FavoritosPresenter favoritosPresenter;
    Context context;

    public FavoritosInteractor(FavoritosPresenter favoritosPresenter, Context context) {
        this.favoritosPresenter = favoritosPresenter;
        this.context = context;
    }

    @Override
    public void crearAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(crearArrayMascotas(), false, false, this.context);
        resultAdapter(adapter);
    }

    private ArrayList<Mascota> crearArrayMascotas() {
        TablaMascotas tablaMascotas = new TablaMascotas(context);
        return tablaMascotas.getMascotasOrderedLikes(this.context);

    }

    @Override
    public void resultAdapter(MascotaAdapter adapter) {
        this.favoritosPresenter.resultAdapter(adapter);
    }
}
