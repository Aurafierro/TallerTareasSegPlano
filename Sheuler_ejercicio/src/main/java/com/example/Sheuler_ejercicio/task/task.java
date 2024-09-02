package com.example.Sheuler_ejercicio.task;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.Sheuler_ejercicio.models.usuario;
import com.example.Sheuler_ejercicio.service.emailService;
import com.example.Sheuler_ejercicio.service.usuarioService;

@Component
public class task {

	@Autowired
    private usuarioService data;

    @Autowired
    private emailService email;

    @Scheduled(cron = "0 30 9 * * *")
    public void enviarNotificacionRegistroCuenta() {
        var listaUsuario = data.cambiarTipoDocumento();
        for (usuario usuario : listaUsuario) {
            System.out.println("Usuario registrado: " + usuario.getNombre_completo());
            email.cambiarTipoDocumento(usuario.getCorreo_electronico(), usuario.getNombre_completo());
        }
    }

    @Scheduled(cron = "0 30 9 * * *")
    public void sendNotificationCambiarTipoDocumento() {
        var listaUsuario = data.cambiarTipoDocumento();
        for (usuario usuario : listaUsuario) {
            System.out.println("Usuario que requiere actualizar documento: " + usuario.getNombre_completo());
            email.cambiarTipoDocumento(usuario.getCorreo_electronico(), usuario.getNombre_completo());
        }
    }

    @Scheduled(cron = "0 30 9 * * *")
    public void sendNotificationActualizarContra() {
        var listaUsuario = data.actualizarContraseña();
        for (usuario usuario : listaUsuario) {
            System.out.println("Usuario que requiere actualizar contraseña: " + usuario.getNombre_completo());
            email.actualizarContraseña(usuario.getCorreo_electronico());
        }
    }

    @Scheduled(cron = "0 30 9 * * *")
    public void sendIniciarSesion() {
        var listaUsuario = data.iniciosesionNotificar();
        for (usuario usuario : listaUsuario) {
            System.out.println("Usuario que debe iniciar sesión: " + usuario.getNombre_completo());
            email.iniciosesionNotificar(usuario.getCorreo_electronico());
        }
    }

}
