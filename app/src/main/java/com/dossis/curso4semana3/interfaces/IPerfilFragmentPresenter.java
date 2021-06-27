package com.dossis.curso4semana3.interfaces;

import com.dossis.curso4semana3.pojo.Mascota;

public interface IPerfilFragmentPresenter extends ICrearAdapter,IResultAdapter{
    void getMascotaPerfil(Mascota mascota);

}
