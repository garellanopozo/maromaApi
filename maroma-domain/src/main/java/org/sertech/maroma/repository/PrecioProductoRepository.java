package org.sertech.maroma.repository;

import java.util.List;

import org.sertech.maroma.domain.PrecioProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Juan on 03/09/2016.
 */
public interface PrecioProductoRepository extends JpaRepository<PrecioProductoEntity,Long> {
	
	@Query(value="select a from PrecioProductoEntity a where deleted = 'N'")
	public List<PrecioProductoEntity> buscarPrecioProducto();
}

