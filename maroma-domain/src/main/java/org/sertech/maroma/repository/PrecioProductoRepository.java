package org.sertech.maroma.repository;

import java.util.List;

import org.sertech.maroma.domain.PrecioProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrecioProductoRepository extends JpaRepository<PrecioProductoEntity,Long> {
	
	@Query(value="select pp from PrecioProductoEntity pp where pp.deleted = 'N'")
	public List<PrecioProductoEntity> buscarPrecioProducto();

	@Query(value="select a from PrecioProductoEntity a inner join fetch a.productoId b "
			+ "where a.productoId.id = :productoId "
			+ "and a.deleted='N' "
			+ "and a.vigenciaDesde <= sysdate() "
			+ "and coalesce(a.vigenciaHasta,sysdate()) >= sysdate()")
	public PrecioProductoEntity buscarPrecioVigentePorProducto(@Param("productoId")Long productoId);
	
	@Query(value="select a from PrecioProductoEntity a inner join fetch a.productoId b "
			+ "where b.descripcion like %:descripcion% "
			+ "and a.deleted='N' "
			+ "and a.vigenciaDesde <= sysdate() "
			+ "and coalesce(a.vigenciaHasta,sysdate()) >= sysdate()")
	public List<PrecioProductoEntity> buscarPrecioVigentePorDescripcionProducto(@Param("descripcion")String productoId);
}