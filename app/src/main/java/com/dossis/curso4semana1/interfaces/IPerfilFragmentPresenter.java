package com.dossis.curso4semana1.interfaces;

import com.dossis.curso4semana1.pojo.Mascota;

public interface IPerfilFragmentPresenter extends ICrearAdapter,IResultAdapter{
    void getMascotaPerfil(Mascota mascota);

}
