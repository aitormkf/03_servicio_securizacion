package com.cursos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.model.Curso;

public interface CursosDao extends JpaRepository<Curso, String> {

}
