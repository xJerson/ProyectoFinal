package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Interfaces.IUsuario;
import Util.ConectarBD;
import model.Perfil;
import model.Usuario;

public class UsuarioImp implements IUsuario{

	@Override
	public void saveUser(Usuario usuario) {
	
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call InsertarUsuario(?,?,?,?,?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.getConexion().prepareCall(sql);
				//asignamos parametros..
				cs.setString(1,usuario.getNombreCompleto());
				cs.setString(2,usuario.getCorreo());
				cs.setString(3,usuario.getContraseña());
				cs.setInt(4,usuario.getPerfil().getIdPerfil());
				cs.setInt(5,usuario.getUsuarioRegistro());
				
				
				
				//ejecutamos
				int x=cs.executeUpdate();
				//aplicamos...
				if(x>0){
					//emitimos un mensaje por consola
					System.out.println("Usuario Registrado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("Usuario No Registrado en la BD");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
		        // Cerrar recursos en el bloque finally para asegurar su liberación
		        if (cs != null) {
		            try {
		                cs.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		        conex.cerrarConexion(); // Método para cerrar la conexión en ConectarBD
		    }
			
		
	}

	@Override
	public void updateUser(Usuario usuario) {
		//instanciamos la clase conectar..
		ConectarBD conex= new ConectarBD();
		
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call ActualizarUsuario(?,?,?,?,?,?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.getConexion().prepareCall(sql);
				//asignamos parametros..
				cs.setInt(1,usuario.getIdUsuario());
				cs.setString(2,usuario.getNombreCompleto());
				cs.setString(3,usuario.getCorreo());
				cs.setString(4,usuario.getContraseña());
				cs.setInt(5,usuario.getPerfil().getIdPerfil());
				cs.setInt(6,usuario.getUsuarioUltModificacion());
				
				//ejecutamos
				int x=cs.executeUpdate();
				//aplicamos...
				if(x>0){
					//emitimos un mensaje por consola
					System.out.println("Usuario Actualizado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("Usuario No Actualizado en la BD");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
		        // Cerrar recursos en el bloque finally para asegurar su liberación
		        if (cs != null) {
		            try {
		                cs.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		        conex.cerrarConexion(); // Método para cerrar la conexión en ConectarBD
		    }
		
	}

	@Override
	public void deleteUser(Usuario usuario) {
		
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al prodecimiento almacenado
		String sql="{call EliminarUsuario(?)}";
		//aplicamos la respectiva interface..
		CallableStatement cs=null;
		try {
			cs=conex.getConexion().prepareCall(sql);
			//asignamos los parametros
			cs.setInt(1,usuario.getIdUsuario());
			
			//realizamos la ejecucion..
			int z=cs.executeUpdate();
			//aplicamos una condicion
			if(z>0){
				//emitimos un mensaje por pantalla
				System.out.println("Usuario Eliminado Correctamente");
				
			}
			else{
				//emitimos un mensaje por pantalla
				System.out.println("Error Al Eliminar");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        // Cerrar recursos en el bloque finally para asegurar su liberación
	        if (cs != null) {
	            try {
	                cs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        conex.cerrarConexion(); // Método para cerrar la conexión en ConectarBD
	    }

		
	}

	@Override
	public Usuario obtenerUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listUsuarios() {
		ConectarBD conex=new ConectarBD();
		//realizamos la respectiva cadena en mysql
		String sql="call ListarUsuarios";
		//aplicamos las interfaces para base de datos
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Usuario> listado=new ArrayList<>();
		
		
		try {
			ps=conex.getConexion().prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				//instanciamos la clase classusuario para almacenar datos de la BD..
			Usuario usuario=new Usuario();
			usuario.setIdUsuario(rs.getInt(1));
			usuario.setNombreCompleto(rs.getString(2));
			usuario.setCorreo(rs.getString(3));
			usuario.setContraseña(rs.getString(4));
			// Instanciamos la clase Perfil y asignamos el idPerfil
            Perfil perfil = new Perfil();
            perfil.setIdPerfil(rs.getInt(5));
            perfil.setNombre(rs.getString(6));
            usuario.setPerfil(perfil);
            
            
            usuario.setUsuarioRegistro(rs.getInt(7));
            // Convertir Timestamp a LocalDateTime
            Timestamp timestampRegistro = rs.getTimestamp(8);
            if (timestampRegistro != null) {
                usuario.setFechaRegistro(timestampRegistro.toLocalDateTime());
            }
            
            usuario.setUsuarioUltModificacion(rs.getInt(9));
            
            Timestamp timestampModificacion= rs.getTimestamp(10);
            if (timestampModificacion != null){
            	usuario.setFechaUltModificacion(timestampModificacion.toLocalDateTime());
            }
            
		    listado.add(usuario);
		    }//fin del bucle
		
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        // Cerrar recursos en el bloque finally para asegurar su liberación
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (ps != null) {
	            try {
	                ps.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        conex.cerrarConexion(); // Método para cerrar la conexión en ConectarBD
	    }
		//realizamos la ejecucion
		
			return listado;
	}

	@Override
	public boolean existCorreo(String correo) {
		 ConectarBD conex = new ConectarBD();
		    Connection con = null;
		    CallableStatement cs = null;
		    boolean existe = false;

		    try {
		        con = conex.getConexion();
		        String sql = "{call existeCorreo(?)}"; // Asegúrate de usar el nombre correcto del procedimiento almacenado
		        cs = con.prepareCall(sql);
		        cs.setString(1, correo);
		        cs.execute();

		        // Obtener el resultado del procedimiento almacenado
		        ResultSet rs = cs.getResultSet();
		        if (rs.next()) {
		            existe = rs.getBoolean("correo_existe");
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (cs != null) {
		            try {
		                cs.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		        if (con != null) {
		            conex.cerrarConexion();
		        }
		    }

		    return existe;
	}

}
