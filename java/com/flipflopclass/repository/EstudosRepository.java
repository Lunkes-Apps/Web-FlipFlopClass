package com.flipflopclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipflopclass.model.Estudo;

public interface EstudosRepository extends JpaRepository<Estudo,Long>{
       public Estudo findByCodigo(int codigo); 
       public List<Estudo> findByModuloNome(String nome); 
}
