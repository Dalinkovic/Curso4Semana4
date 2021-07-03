package com.dossis.curso4semana4.interfaces;

import com.dossis.curso4semana4.pojo.Mascota;

public interface IPerfilFragmentInteractor extends ICrearAdapter,IResultAdapter{
    void crearMascotaPerfilFake();
    void getMascotaPerfil(Mascota mascota);
}
