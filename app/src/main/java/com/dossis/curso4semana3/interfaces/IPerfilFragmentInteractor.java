package com.dossis.curso4semana3.interfaces;

import com.dossis.curso4semana3.pojo.Mascota;

public interface IPerfilFragmentInteractor extends ICrearAdapter,IResultAdapter{
    void crearMascotaPerfilFake();
    void getMascotaPerfil(Mascota mascota);
}
