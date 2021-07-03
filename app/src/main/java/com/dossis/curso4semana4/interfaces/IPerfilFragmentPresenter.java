package com.dossis.curso4semana4.interfaces;

import com.dossis.curso4semana4.pojo.Mascota;

public interface IPerfilFragmentPresenter extends ICrearAdapter,IResultAdapter{
    void getMascotaPerfil(Mascota mascota);

}
