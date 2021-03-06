package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.UsuarioService;
import ar.edu.unlam.diit.scaw.services.impl.UsuarioServiceImpl;

@ManagedBean(name = "usuarioBean", eager = true)
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String eMail = null;
	private String contraseña = null;
	private Integer id = null;
	private String apellido = null;
	private String nombre = null;
	
	UsuarioService service;

	public UsuarioBean() {
		super();
		service = (UsuarioService) new UsuarioServiceImpl();
	}
	
	public UsuarioBean(String eMail, String contraseña, Integer id, String apellido, String nombre) {
		super();
		this.eMail = eMail;
		this.contraseña = contraseña;
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
	}
	
	public String save() {
		
		Usuario person = buildUsuario();
		
		service.save(person);
		
		return "/modulos/usuario/lista.xhtm";
	}
	
	public String delete(Integer id){
		
		this.service.delete(id);
		
		return "/modulos/usuario/lista.xhtm";
	}
	
	private Usuario selectedUser;
	
	public void setSelectedUser(Usuario selectedUser) {
		this.selectedUser = selectedUser;
	}
 
	public Usuario getSelectedUser() {
		return selectedUser;
	}
	
	public String editUsuario(Usuario usuario){
		
	
		this.service.edit(id);
//		Usuario usuario = new Usuario();
//		
//		usuario.setEmail(this.nombre);
//		usuario.setContraseña(this.apellido);	
//		usuario.setEmail(this.eMail);
		
	    return "/modulos/usuario/editar.xhtml";
   }
		
	public List<Usuario> getFindAll() {
		List<Usuario> list = service.findAll();
		return list;
	}
	
	public String login(){
		
		Usuario usuario = new Usuario();
		usuario.setEmail(this.eMail);
		usuario.setContraseña(this.contraseña);		
		
		Usuario logueado = service.login(usuario);		
		if(logueado!=null) 
		{
			return "/templates/panel/panel.xhtml";
		}
		else
		{
			return "index";
		}		
	}	

	private Usuario buildUsuario() {
		Usuario usuario = new Usuario();
		
		usuario.setEmail(this.eMail);
		usuario.setContraseña(contraseña);
		usuario.setId(id);
		usuario.setApellido(this.apellido);
		usuario.setNombre(this.nombre);
		
		return usuario;
	}
	
	public String getEmail() {
		return eMail;
	}

	public void setEmail(String email) {
		this.eMail = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UsuarioService getService() {
		return service;
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
