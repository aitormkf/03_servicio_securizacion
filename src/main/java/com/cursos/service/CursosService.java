package com.cursos.service;

import java.util.List;

import com.cursos.model.Curso;

public interface CursosService {
	
	List<Curso> cursos();
	List<Curso> altaCurso(Curso curso);
	List<Curso> eliminarCurso(String codCurso);
	void actualizarCurso(String codCurso,int horas);
	Curso buscarCurso(String codCurso);
	List<Curso> BuscarCursosRango(double precioMin, double precioMax);
	
	
	
	

}
