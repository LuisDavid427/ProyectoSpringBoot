package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Company;

@Repository
public interface CompanyRepository 
extends JpaRepository<Company, Integer>
{
	
	// Consulta personalizada para filtrar por una parte del nombre (usando JPQL)
	@Query(""
			+ "SELECT "
			+ "c "
			+ "FROM "
			+ "company c " // Usamos el nombre de la CLASE/ENTIDAD (Company)
			+ "WHERE "
			+ "c.companyName like %?1%"
			)
	public List<Company> filterByCompanyName(String name);
}