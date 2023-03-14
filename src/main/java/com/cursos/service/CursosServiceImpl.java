package com.cursos.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.dao.CursosDao;
import com.cursos.model.Curso;

@Service
public class CursosServiceImpl implements CursosService{
    
	
	@Autowired
	CursosDao dao;
	
	
	@Override
	public List<Curso> cursos() {
		
		return dao.findAll();
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {
		dao.save(curso);
		
		return dao.findAll();
	}

	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
	public void actualizarCurso(String codCurso, int horas) {
		Curso curso = buscarCurso(codCurso);
		curso.setDuracion(horas);
		dao.save(curso);
		
	}

	@Override
	public Curso buscarCurso(String codCurso) {
		return dao.findById(codCurso).orElse(null);
		 
	}

	@Override
	public List<Curso> BuscarCursosRango(double precioMin, double precioMax) {
		List<Curso> cursos = dao.findAll();
		return  cursos
				.stream()
				.filter(c->c.getPrecio()>precioMin && c.getPrecio()<precioMax )
				.collect(Collectors.toList());
		
		
				
	}

}
