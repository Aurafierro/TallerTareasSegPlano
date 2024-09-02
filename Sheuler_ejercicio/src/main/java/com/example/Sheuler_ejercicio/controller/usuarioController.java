package com.example.Sheuler_ejercicio.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sheuler_ejercicio.interfaceService.IUsuarioService;
import com.example.Sheuler_ejercicio.models.usuario;
import com.example.Sheuler_ejercicio.service.emailService;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin
public class usuarioController {
	
@Autowired 
	
	private IUsuarioService usuarioService;

@Autowired
private emailService emailService;


	@PostMapping("/")
public ResponseEntity<Object> save(@RequestBody usuario usuario) {
	    
	    List<usuario> usuarios = usuarioService.filtroIngresoUsuario(usuario.getNumero_documento());
	    if (!usuarios.isEmpty()) {
	        return new ResponseEntity<>("El usuario ya se encuentra registrado", HttpStatus.BAD_REQUEST);
	    }
	    if (usuario.getTipo_documento().equals("")) {

            return new ResponseEntity<>("El tipo de documento es obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (usuario.getNumero_documento().equals("")) {
            
            return new ResponseEntity<>("El numero de documento es obligatorio", HttpStatus.BAD_REQUEST);
        }
        
if (usuario.getNombre_completo().equals("")) {
            
            return new ResponseEntity<>("El nombre completo es obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if ( usuario.getFecha_nacimiento().equals("")) {
            
            return new ResponseEntity<>("La fecha de nacimiento es obligatoria", HttpStatus.BAD_REQUEST);
        }

        if (usuario.getContrasena().equals("")) {
            
            return new ResponseEntity<>("La contrasena es obligatoria", HttpStatus.BAD_REQUEST);
        }
        
        if (usuario.getFecha_ultima_actualizacion_contrasena().equals("")) {

            return new ResponseEntity<>("La fecha de ultima actualizacion contrasena es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getFecha_ultimo_inicio_sesion().equals("")) {

            return new ResponseEntity<>("La fecha de ultimo inicio de sesion es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getEstado().equals("")) {

            return new ResponseEntity<>("El estado es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getCorreo_electronico().equals("")) {

            return new ResponseEntity<>("El correo electronico es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getNotificacion().equals("")) {

            return new ResponseEntity<>("La notificacion es obligatoria", HttpStatus.BAD_REQUEST);
        }
        
        
        
     
		usuarioService.save(usuario);
		emailService.enviarNotificacionRegistroCuenta(usuario.getNombre_completo(),usuario.getCorreo_electronico());
		return new ResponseEntity<>(usuario,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object>findAll(){
		var ListaUsuario = usuarioService.findAll();
		return new ResponseEntity<>(ListaUsuario, HttpStatus.OK);
	}
	
	//filtro
	@GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
		var ListaUsuario = usuarioService.filtroUsuario(filtro);
		return new ResponseEntity<>(ListaUsuario, HttpStatus.OK);
	}
	
	@GetMapping("/mayoriaedad")
    public ResponseEntity<Object> findEdad() {
        var listaUsuario = usuarioService.cambiarTipoDocumento();
        return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
    }
	
	@GetMapping("/actualizarContraseña")
    public ResponseEntity<Object> findActualizarContraseña() {
        var listaUsuario = usuarioService.actualizarContraseña();
        return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
    }
	//@PathVariable recibe una variable por el enlace
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity<Object> findOne ( @PathVariable String id_usuario){
		var usuario= usuarioService.findOne(id_usuario);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
			@PutMapping("/{id_usuario}")
			public ResponseEntity<Object> update(@PathVariable String id_usuario, @RequestBody usuario usuarioUpdate) {
			    
				// Verificar si hay campos vacíos
				
				if (usuarioUpdate.contieneCamposVacios()) {
					return new ResponseEntity<>("Todos los campos son obligatorios", HttpStatus.BAD_REQUEST);
				}

				var usuario = usuarioService.findOne(id_usuario).get();
				if (usuario != null) {
					  // Verificar si el titulo se está cambiando
			        if (!usuario.getNumero_documento().equals(usuarioUpdate.getNumero_documento())) {
			            // El titulo se está cambiando, verificar si ya está en uso
			            List<usuario> usuarios_con_mismo_numDocumento = usuarioService.filtroIngresoUsuario(usuarioUpdate.getNumero_documento());
			            if (!usuarios_con_mismo_numDocumento.isEmpty()) {
			                // Si hay otros libros con el mismo número de documento, devuelve un error
			                return new ResponseEntity<>("El usuario ya está registrado", HttpStatus.BAD_REQUEST);
			            }
			        }


					usuario.setTipo_documento(usuarioUpdate.getTipo_documento());
					usuario.setNumero_documento(usuarioUpdate.getNumero_documento());
					usuario.setNombre_completo(usuarioUpdate.getNombre_completo());
					usuario.setFecha_nacimiento(usuarioUpdate.getFecha_nacimiento());
					usuario.setContrasena(usuarioUpdate.getContrasena());
					usuario.setFecha_ultima_actualizacion_contrasena(usuarioUpdate.getFecha_ultima_actualizacion_contrasena());
					usuario.setFecha_ultimo_inicio_sesion(usuarioUpdate.getFecha_ultimo_inicio_sesion());
					usuario.setEstado(usuarioUpdate.getEstado());
					usuario.setCorreo_electronico(usuarioUpdate.getCorreo_electronico());
					usuario.setNotificacion(usuarioUpdate.getNotificacion());

					usuarioService.save(usuario);
					return new ResponseEntity<>("Guardado", HttpStatus.OK);

				} else {
					return new ResponseEntity<>("Error, usuario no encontrado", HttpStatus.BAD_REQUEST);
				}
			}
			
			@DeleteMapping("/{id_usuario}")
			public ResponseEntity<Object>delete (@PathVariable("id_usuario")String id_usuario){
				usuarioService.delete(id_usuario);
				return new ResponseEntity<>("Usuario eliminado",HttpStatus.OK);
			}
	


}
