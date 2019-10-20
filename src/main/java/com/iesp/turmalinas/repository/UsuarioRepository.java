package com.iesp.turmalinas.repository;

import org.springframework.data.repository.CrudRepository;

import com.iesp.turmalinas.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	Usuario findByLogin(String login);

}
