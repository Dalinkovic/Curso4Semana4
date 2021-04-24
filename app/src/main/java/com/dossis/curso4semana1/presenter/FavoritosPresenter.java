package com.dossis.curso4semana1.presenter;

import com.dossis.curso4semana1.Interactors.FavoritosInteractor;
import com.dossis.curso4semana1.activitys.FavoritosActivityView;
import com.dossis.curso4semana1.adapter.MascotaAdapter;
import com.dossis.curso4semana1.interfaces.IFavoritosPresenter;

public class FavoritosPresenter implements IFavoritosPresenter {
    FavoritosActivityView favoritosActivityView;
    FavoritosInteractor favoritosInteractor;

    public FavoritosPresenter(FavoritosActivityView favoritosActivityView) {
        this.favoritosActivityView = favoritosActivityView;
        this.favoritosInteractor = new FavoritosInteractor(this, this.favoritosActivityView.getBaseContext());
    }

    @Override
    public void crearAdapter() {

        favoritosInteractor.crearAdapter();
    }

    @Override
    public void resultAdapter(MascotaAdapter adapter) {
        favoritosActivityView.resultAdapter(adapter);
    }
}
