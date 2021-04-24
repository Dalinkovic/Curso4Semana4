package com.dossis.curso4semana1.interfaces;

import com.dossis.curso4semana1.pojo.Mascota;

public interface IPerfilFragmentInteractor extends ICrearAdapter,IResultAdapter{
    void crearMascotaPerfilFake();
    void getMascotaPerfil(Mascota mascota);
}
