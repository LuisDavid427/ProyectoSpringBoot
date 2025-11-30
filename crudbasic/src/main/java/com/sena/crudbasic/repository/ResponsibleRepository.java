package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Responsible;

@Repository
public interface ResponsibleRepository 
extends JpaRepository<Responsible, Integer>
{
	
	/*
	 * Consulta Derivada: Encuentra Responsables por el ID de la Persona.
	 */
	public List<Responsible> findByPerson_IdPerson(int idPerson);
    
    /*
	 * Consulta Derivada: Busca Responsables por el ID del Producto.
	 */
	public List<Responsible> findByProduct_IdProduct(int idProduct);
    
    /*
     * Consulta Derivada: Encuentra un Responsible específico por sus dos claves foráneas.
     * Útil para verificar duplicados.
     */
    public Responsible findByPerson_IdPersonAndProduct_IdProduct(int idPerson, int idProduct);
}