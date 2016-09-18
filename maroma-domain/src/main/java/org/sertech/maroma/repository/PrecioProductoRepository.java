package org.sertech.maroma.repository;

import java.util.List;

import org.sertech.maroma.domain.PrecioProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Juan on 03/09/2016.
 */
public interface PrecioProductoRepository extends JpaRepository<PrecioProductoEntity,Long> {
	
	@Query(value="select pp from PrecioProductoEntity pp where pp.deleted = 'N'")
	public List<PrecioProductoEntity> buscarPrecioProducto();

	@Query(value="select pp from PrecioProductoEntity pp "
			+ "where pp.productoId.id = :productoId "
			+ "and pp.deleted='N' "
			+ "and pp.vigenciaDesde <= sysdate "
			+ "and coalesce(pp.vigenciaHasta,sysdate) >= sysdate")
	public PrecioProductoEntity buscarPrecioVigentePorProducto(@Param("productoId")Long productoId);
}

