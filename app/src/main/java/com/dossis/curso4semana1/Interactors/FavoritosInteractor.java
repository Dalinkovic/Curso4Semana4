package com.dossis.curso4semana1.Interactors;

import android.content.Context;

import com.dossis.curso4semana1.adapter.MascotaAdapter;
import com.dossis.curso4semana1.database.*;
import com.dossis.curso4semana1.interfaces.IFavoritosInteractor;
import com.dossis.curso4semana1.pojo.Mascota;
import com.dossis.curso4semana1.presenter.FavoritosPresenter;

import java.util.ArrayList;

public class FavoritosInteractor implements IFavoritosInteractor {
    FavoritosPresenter favoritosPresenter;
    Context context;

    public FavoritosInteractor(FavoritosPresenter favoritosPresenter, Context context) {
        this.favoritosPresenter = favoritosPresenter;
        this.context=context;
    }

    @Override
    public void crearAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(crearArrayMascotas(), false, false);
        resultAdapter(adapter);
    }

    private ArrayList<Mascota> crearArrayMascotas() {
        TablaMascotas tablaMascotas = new TablaMascotas();
        ArrayList<Mascota> mascotasOrdenadas = tablaMascotas.getMascotasOrderedLikes(this.context);
        return mascotasOrdenadas;

    }

    @Override
    public void resultAdapter(MascotaAdapter adapter) {
        this.favoritosPresenter.resultAdapter(adapter);
    }
}
