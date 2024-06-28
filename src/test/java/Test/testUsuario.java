package Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import Dao.UsuarioImp;
import model.Perfil;
import model.Usuario;

public class testUsuario {

	public static void main(String[] args) {
		//testcorreoExiste();
		//testListadoUsuario();
		//testsaveuser();
		//testUpdateUser();
		testEliminarUser();
	}

	public static void testsaveuser(){
		Usuario nuevo = new Usuario();
		nuevo.setNombreCompleto("Hana");
		nuevo.setCorreo("hana@gmail.com");
		nuevo.setContraseña("123456");
		Perfil perfil = new Perfil();
		perfil.setIdPerfil(2);
		nuevo.setPerfil(perfil);
		nuevo.setUsuarioRegistro(32);
		
		System.out.println("Registrando Usuario............");
		UsuarioImp cruduser = new  UsuarioImp();
		cruduser.saveUser(nuevo);
	}
	
	public static void testUpdateUser(){
		Usuario update = new Usuario();
		
		update.setIdUsuario(33);
		update.setNombreCompleto("Hana");
		update.setCorreo("hana@hotmail.com");
		update.setContraseña("1234");
		Perfil perfil = new Perfil();
		perfil.setIdPerfil(2);
		update.setPerfil(perfil);
		update.setUsuarioUltModificacion(32);
		
		System.out.println("Actualizando Usuario............");
		UsuarioImp cruduser = new  UsuarioImp();
		cruduser.updateUser(update);
	}
	
	public static void testEliminarUser(){
		Usuario eliminado = new Usuario();
		eliminado.setIdUsuario(33);
		UsuarioImp cruduser = new UsuarioImp();
		
		System.out.println("Eliminando usuario...");
		cruduser.deleteUser(eliminado);
	}
	
	
	public static void testcorreoExiste() {
		UsuarioImp usuarioImp = new UsuarioImp();
		String correo = "jerson@gmail.com";
		boolean correoExiste = usuarioImp.existCorreo(correo);

		if (correoExiste) {
			System.out.println("El correo " + correo + " ya existe en la base de datos.");
		} else {
			System.out.println("El correo " + correo + " no existe en la base de datos.");
		}
	}

	public static void testListadoUsuario() {
		UsuarioImp listado = new UsuarioImp();

		List<Usuario> listusuarios = listado.listUsuarios();
		if (listusuarios.isEmpty()) {
			System.out.println("No se encontraron usuarios en la base de datos.");
		} else {
			
			System.out.println("Listado de usuarios:");
			
			 // Define el formato deseado para la fecha y hora
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			for (Usuario usuario : listusuarios) {
				System.out.println( "---------------------------------------------------------------" + ("\n") + 
									"codigo : " + usuario.getIdUsuario() + ("\n") +
									"nombre : " + usuario.getNombreCompleto() + ("\n") +
									"correo : " + usuario.getCorreo() + ("\n") +
									"contraseña : " + usuario.getContraseña() + ("\n") +
									"Rol : " + usuario.getPerfil().getIdPerfil() + ("\n") +
									"RegistradoPorId : " + usuario.getUsuarioRegistro() + ("\n") +
									"fecha de registro : " +usuario.getFechaRegistro().format(formatter) + ("\n") +
									"ModificadoPorId : " + usuario.getFechaUltModificacion().format(formatter) + ("\n") +
									"Fecha de Modificacion : " + usuario.getFechaUltModificacion()+ ("\n"));
			}
		}

	}
}
