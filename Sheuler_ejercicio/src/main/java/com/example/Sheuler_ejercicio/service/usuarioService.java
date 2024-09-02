package com.example.Sheuler_ejercicio.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Sheuler_ejercicio.interfaceService.IUsuarioService;
import com.example.Sheuler_ejercicio.interfaces.IUsuario;
import com.example.Sheuler_ejercicio.models.usuario;

@Service
public class usuarioService implements IUsuarioService{

	@Autowired 
	private IUsuario data;
	
	@Override
	public String save(usuario usuario) {
		data.save(usuario);
		return usuario.getId_usuario();
	}

	@Override
	public List<usuario> findAll() {
		List <usuario> listaUsuario = (List<usuario>) data.findAll() ;
		
		return listaUsuario;
	}

	@Override
	public List<usuario> filtroUsuario(String usuario) {
		List <usuario> listaUsuario=data.filtroUsuario(usuario);
		return listaUsuario;
	}
	
	
	@Override
	public Optional<usuario> findOne(String id_usuario) {
		Optional<usuario>usuario=data.findById(id_usuario);
		
		return usuario;
	}

	@Override
	public int delete(String id_usuario) {
		data.deleteById(id_usuario);
		return 1;
	}
	
    
	@Override

	public List<usuario> filtroIngresoUsuario(String numero_documento) {
		List<usuario> listaUsuario=data.filtroIngresoUsuario(numero_documento);
		return listaUsuario;
	}
	
	 @Override
	    public List<usuario> cambiarTipoDocumento() {
	        List<usuario> listaUsuario = data.cambiarTipoDocumento();
	        return listaUsuario;
	    }
	
	
	@Override
    public List<usuario> actualizarContraseña() {
        List<usuario> listaUsuario = data.actualizarContraseña();
        return listaUsuario;
    }

    
    @Override
    public List<usuario> iniciosesionNotificar() {
        List<usuario> listaUsuario = data.iniciosesionNotificar();
        return listaUsuario;
    }
	
}
