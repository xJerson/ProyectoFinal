package Interfaces;

import java.util.List;

import model.Tarea;

public interface ITarea {

	void save(Tarea Tarea);
	void update(Tarea Tarea);
	void delete(Tarea Tarea);
	List<Tarea> list();
}
