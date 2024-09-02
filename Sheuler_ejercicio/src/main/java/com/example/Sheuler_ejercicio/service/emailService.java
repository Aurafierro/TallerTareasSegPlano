package com.example.Sheuler_ejercicio.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public String enviarNotificacionRegistroCuenta(String destinatario, String nombre_completo ) {

		try {
			TimeUnit.MINUTES.sleep(5);
			String asunto = "Bienvenid@ " + nombre_completo + " a esta página";
	        String cuerpo = "<body style='margin: 0; padding: 0; background-color: #CCCCCC;'>"
	            + "<div style='background-color: white; max-width: 600px; margin: auto; padding: 20px; box-sizing: border-box;'>"
	            + "<div style='background-color: #202C4A; padding: 11px; text-align: center;'>"
	            + "</div>"
	            + "<h1 style='color: #2B56C5; text-align: center; font-size: 24px; margin-top: 20px;'>¡Bienvenid@, " + nombre_completo + " a este sitio web!</h1>"
	            + "<p style='color: #000; font-size: 16px; line-height: 1.5; margin-top: 20px;'>"
	            + "Gracias por registrarte! Estamos encantados de tenerte con nosotros. Ahora que eres parte de nuestra comunidad, podrás disfrutar de todas las funciones y beneficios que ofrecemos."
	            + "Si tienes alguna pregunta o necesitas ayuda para comenzar, no dudes en visitar nuestra sección de soporte o nuestras preguntas frecuentes. Estamos aquí para ayudarte a sacar el máximo provecho"
	            + "de nuestra plataforma."
	            + "¡Explora, aprende y disfruta! Nos alegra mucho que hayas decidido unirte a nosotros."
	            + "</p>"
	            + "</div>"
	            + "</body>";
			        
			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "Se envió correctamente";
			}else {
				return "No se pudo enviar";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}
	
	public String cambiarTipoDocumento(String destinatario, String nombre_completo) {

		try {
			
			String asunto="Hola " +nombre_completo + " ";
			String cuerpo=""
					+"<body style='margin: 0; padding: 0; background-color: #CCCCCC;'>"
					+"   <div style='background-color: #CCCCCC;'>"
		   +"     <div style='background-color: white; max-width: 600px; margin: auto; padding: 20px; box-sizing: border-box;'>"
		    +"        <header style='text-align: center; background-color: #000; color: #fff; padding: 30px;'>"
		    +"       </header>"
		     +"       <h1 style='color: #252525; text-align: center; font-size: 24px; margin-top: 20px;'>Cambio de documento </h1>"
		     +"       <p style='color: #000; font-size: 16px; line-height: 1.5; margin-top: 20px;'>"
		              
		               
		       +"         Recuerda en hacer el cambio de tu tipo de documents por temas de politicas y privacidad."

		      +"      </p>"
		            
		           
		     +"   </div>"
		+"    </div>"
		    +"</body>";
			        
			var retorno=enviarCorreo(destinatario,asunto,cuerpo);
			if(retorno) {
				return "Se envió correctamente";
			}else {
				return "No se pudo enviar";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return "Error al envíar "+e.getMessage();
		}
	}
	

    public String actualizarContraseña(String destinatario){
        try{
            String asunto = "Actualiza tu contraseña";
            String cuerpo = ""
            	+"	<body style='margin: 0; padding: 0; background-color: #CCCCCC;'>"
            	+"  <div style='background-color: #CCCCCC;'>"
           +"     <div style='background-color: white; max-width: 600px; margin: auto; padding: 20px; box-sizing: border-box;'>"
            +"        <header style='text-align: center; background-color: #000; color: #fff; padding: 30px;'>"
            +"        </header>"
            +"        <h1 style='color: #252525; text-align: center; font-size: 24px; margin-top: 20px;'>Recordatorio cambio contraseña </h1>"
            +"        <p style='color: #000; font-size: 16px; line-height: 1.5; margin-top: 20px;'>"
                      
                       
          +"              Te informamos que, por razones de seguridad, es necesario que cambies tu contraseña para"
          +"               asegurar el acceso continuo a tu cuenta."
     +"   <br>"
           +"             Para realizar el cambio"
          +"          </p>"
                    
                   
       +"         </div>"
       +"     </div>"
      +"  </body>";


            

            var retorno=enviarCorreo(destinatario,asunto,cuerpo);
            if(retorno) {
                return "se envió correctamente";
            }else {
                return "No se pudo envíar";
            }

        }catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar "+e.getMessage();
        }
    }
    
    public String iniciosesionNotificar(String destinatario){
        try{
            String asunto = "Inicia sesión para evitar el bloqueo de tu cuenta";
            String cuerpo = ""
            	+"	<body style='margin: 0; padding: 0; background-color: #CCCCCC;'>"
            	+" <div style='background-color: #CCCCCC;'>"
          +"      <div style='background-color: white; max-width: 600px; margin: auto; padding: 20px; box-sizing: border-box;'>"
            +"        <header style='text-align: center; background-color: #000; color: #fff; padding: 30p;'>"
            +"      </header>"
              +"      <h1 style='color: #252525; text-align: center; font-size: 24px; margin-top: 20px;'>Inactividad de tu cuenta </h1>"
                +"    <p style='color: #000; font-size: 16px; line-height: 1.5; margin-top: 20px;'>"
                      
                       
                  +"      Tu cuenta ha estado inactiva durante más de 30 días. Debido a la inactividad prolongada, hemos procedido a bloquear tu cuenta para proteger tu seguridad."

                    +"    Si deseas reactivar tu cuenta, por favor contacta con nuestro soporte técnico para obtener asistencia."
                        
                      +"  Gracias por tu comprensión."
                        
                    +"</p>"
                    
                   
                +"</div>"
            +"</div>"
        +"</body>";

            var retorno=enviarCorreo(destinatario,asunto,cuerpo);
            if(retorno) {
                return "se envió correctamente";
            }else {
                return "No se pudo envíar";
            }

        }catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar "+e.getMessage();
        }
    }

	
	private boolean enviarCorreo(String destinatario,String asunto,String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);
			
			javaMailSender.send(message);
			return true;
		}catch (Exception e) {

			return false;
		}
		
	}
}
