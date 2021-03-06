package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;
import ar.edu.unlam.diit.scaw.daos.impl.UsuarioDaoImpl;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	UsuarioDaoImpl usuarioHsql;
	
	public UsuarioServiceImpl(){
		usuarioHsql = new UsuarioDaoImpl();
	}
	
	@Override
	public Usuario login(Usuario usuario){
		return usuarioHsql.login(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioHsql.findAll();
	}

	public UsuarioDaoImpl getUsuarioHsql() {
		return usuarioHsql;
	}

	public void setUsuarioHsql(UsuarioDaoImpl personHsql) {
		this.usuarioHsql = personHsql;
	}

	@Override
	public void save(Usuario usuario) {
		this.usuarioHsql.save(usuario);
	}
	
	@Override
	public void delete(Integer id){
		this.usuarioHsql.delete(id);
	}
	
	@Override
	public List<Usuario> edit(Integer id){
		return usuarioHsql.edit(id);
	}
	
//	@Override
//	public void update(Usuario usuario){
//		this.usuarioHsql.update(usuario);
//	}
}
