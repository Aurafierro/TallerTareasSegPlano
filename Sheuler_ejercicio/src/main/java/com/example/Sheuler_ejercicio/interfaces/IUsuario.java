package com.example.Sheuler_ejercicio.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.Sheuler_ejercicio.models.usuario;


@Repository
public interface IUsuario extends CrudRepository <usuario,String> {

	@Query("SELECT u FROM usuario u WHERE "
			+ "u.tipo_documento LIKE %?1% OR "
			+ "u.numero_documento LIKE %?1% OR "
			+ "u.fecha_nacimiento=?1 OR "
			+ "u.contrasena LIKE %?1% OR "
			+ "u.fecha_ultima_actualizacion_contrasena =?1 OR "
			+ "u.fecha_ultimo_inicio_sesion =?1 OR "
			+ "u.estado LIKE %?1% OR "
			+ "u.correo_electronico LIKE %?1%")
	List<usuario>filtroUsuario (String filtro);
	
	@Query("SELECT u FROM usuario u WHERE u.numero_documento = ?1 AND u.estado='H'")
	List<usuario> filtroIngresoUsuario(String numero_documento );
	
	@Query ("SELECT u FROM usuario u WHERE TIMESTAMPDIFF(YEAR, u.fecha_nacimiento, NOW())>=18 AND u.tipo_documento='TI'")
    List<usuario> cambiarTipoDocumento();
    
    @Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.fecha_ultima_actualizacion_contrasena) >= 90")
    List<usuario> actualizarContraseña();

    @Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.fecha_ultimo_inicio_sesion) >= 30")
    List<usuario> iniciosesionNotificar();
}
