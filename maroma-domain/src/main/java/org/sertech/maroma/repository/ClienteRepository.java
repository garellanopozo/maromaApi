package org.sertech.maroma.repository;

import org.sertech.maroma.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jzapata on 27/08/2016.
 */
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
}

