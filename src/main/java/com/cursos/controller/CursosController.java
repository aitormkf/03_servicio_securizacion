package com.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.model.Curso;
import com.cursos.service.CursosService;


@CrossOrigin("*")
@RestController
@RequestMapping("curso")
public class CursosController {
	
	@Autowired
	CursosService service;
	
	
	
	@GetMapping(value="/lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> ListaCursos() {
		
		return service.cursos();
	}
	
	@PostMapping(value="/alta",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> AltaCurso(@RequestBody Curso curso) {
		
		return service.altaCurso(curso);
	}
	
	@PutMapping(value="/actualizar/{codCurso}/{horas}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void ActualizarCurso(@PathVariable("codCurso") String codCurso,@PathVariable("horas") int horas) {
		
		 service.actualizarCurso(codCurso,horas);
	}

	@GetMapping(value="/buscar/{codCurso}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso BuscarCurso(@PathVariable("codCurso") String codCurso) {
		
		return service.buscarCurso(codCurso);
	}
	@GetMapping(value="rango/{precioMin}/{precioMax}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> CursoRango(@PathVariable("precioMin") String precioMin,@PathVariable("precioMax") String precioMax) {
		
		return service.BuscarCursosRango(Double.parseDouble(precioMin),Double.parseDouble(precioMax));
	}
	
	@DeleteMapping(value="/eliminar/{codCurso}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> EliminarCurso(@PathVariable("codCurso") String codCurso) {
		
		return service.eliminarCurso(codCurso);
	}
	
}
