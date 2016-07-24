package org.sertech.maroma.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

/**
 * Created by German on 23/07/2016.
 */
@Entity
@Data
@EntityListeners({AuditingEntityListener.class})
public class ProductoEntity extends AbstractAuditable<ProductoEntity, Long> {

    /*@Id
    @Column(name = "prod_id")
    private Integer prodId;*/

    @Column(name="prod_cod")
    private String prodCod;

    @Column(name="prod_name")
    private String prodName;

}
