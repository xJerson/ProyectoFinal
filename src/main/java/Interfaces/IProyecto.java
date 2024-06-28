package Interfaces;

import java.util.List;

import model.Proyecto;

public interface IProyecto {

	void saveProyecto(Proyecto proyecto);
	void updateProyecto(Proyecto proyecto);
	void deleteProyecto(Proyecto proyecto);
	Proyecto obtenerProyecto(int id);
	List<Proyecto> ListProyectos();
	boolean existProyecto(int id);
}
