package Interfaces;

import java.util.List;

import model.Perfil;

public interface IPerfil {

	void save(Perfil Perfil);
	void update(Perfil Perfil);
	void delete(Perfil Perfil);
	List<Perfil> list();
}
