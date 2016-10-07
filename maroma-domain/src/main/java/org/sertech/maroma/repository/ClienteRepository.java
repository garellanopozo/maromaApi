package org.sertech.maroma.repository;

import java.util.List;

import org.sertech.maroma.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by jzapata on 27/08/2016.
 */
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
	
	@Query(value="from ClienteEntity c where c.numeroDeIdentIdentificacion=:numeroDocumento and c.deleted <> 'Y' ")
	public List<ClienteEntity> buscarPorDocumentoIdentidad(@Param("numeroDocumento")String numeroDocumento);
	
	@Query(value="from ClienteEntity c where c.apellido like %:apellido% and c.deleted <> 'Y' ")
	public List<ClienteEntity> buscarPorApellido(@Param("apellido")String apellido);
	
}

