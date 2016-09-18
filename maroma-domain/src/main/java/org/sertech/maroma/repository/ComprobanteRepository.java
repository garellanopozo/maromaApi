package org.sertech.maroma.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.sertech.maroma.domain.ComprobanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComprobanteRepository extends JpaRepository<ComprobanteEntity,Long> {
	
	@Query("from ComprobanteEntity c where c.clienteId.id = :clienteId and c.deleted = 'N'")
	public List<ComprobanteEntity> buscarPorCliente(
			@Param("clienteId")Long clienteId);
	
	@Query("from ComprobanteEntity c where c.clienteId.id = :clienteId and c.deleted = 'N' "
			+ "and date(c.fechaDeEmision) = date(:fechaEmision)")
	public List<ComprobanteEntity> buscarPorClienteYFecha(
			@Param("clienteId")Long clienteId, @Param("fechaEmision")DateTime fechaEmision);
}

