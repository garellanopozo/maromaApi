package org.sertech.maroma.repository;

import org.sertech.maroma.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by German on 23/07/2016.
 */
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}

