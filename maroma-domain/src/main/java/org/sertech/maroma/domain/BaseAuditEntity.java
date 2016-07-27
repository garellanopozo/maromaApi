package org.sertech.maroma.domain;

import lombok.Data;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
@EntityListeners({ AuditingEntityListener.class })
public class BaseAuditEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@CreatedBy
	@Column(name = "createdby")
	private String createdBy;
	
	@CreatedDate
	@Column(name = "createddate")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters={@Parameter(name="databaseZone", value="jvm")})
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private DateTime createdDate;
	
	@LastModifiedBy
	@Column(name = "lastmodifiedby")
	private String lastModifiedBy;
	
	@LastModifiedDate
	@Column(name = "lastmodifieddate")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters={@Parameter(name="databaseZone", value="jvm")})
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private DateTime lastModifiedDate;
	
	@Column(name = "deleted")
	private String deleted = "N";
}
