package org.sertech.maroma.repository;

import java.util.List;

import org.sertech.maroma.domain.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by German on 23/07/2016.
 */
public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
	
	@Query(value="select a from ProductoEntity a where deleted = 'N'")
	public List<ProductoEntity> buscarProducto();
	
	@Query(value="select a from ProductoEntity a inner join fetch a.categoriaId where a.deleted = 'N' and a.descripcion like %:description%")
	public List<ProductoEntity> buscarProductoByDescription(@Param("description")String description );
	
}

