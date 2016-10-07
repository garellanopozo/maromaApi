package org.sertech.maroma.canonical;

import java.io.Serializable;

import org.sertech.maroma.dto.ClienteDTO;

import lombok.Data;

@Data
public class ClienteCanonicalRequest extends BaseCanonicalRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ClienteDTO clienteDto;
	
}
