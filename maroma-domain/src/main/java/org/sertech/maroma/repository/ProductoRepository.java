package org.sertech.maroma.repository;

import java.util.List;

import org.sertech.maroma.domain.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by German on 23/07/2016.
 */
public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
	
	@Query(value="select a from ProductoEntity a where deleted = 'N'")
	public List<ProductoEntity> buscarProducto();
}

