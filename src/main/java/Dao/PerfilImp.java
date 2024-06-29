package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Interfaces.IPerfil;
import Util.ConectarBD;
import model.Perfil;
import model.Perfil;
import model.Usuario;

import java.time.LocalDate;

public class PerfilImp implements IPerfil{

	@Override
	public void save(Perfil Perfil) {
	
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call InsertarPerfil(?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.getConexion().prepareCall(sql);
				//asignamos parametros..
				cs.setString(1,Perfil.getNombre());
				
				//ejecutamos
				int x=cs.executeUpdate();
				//aplicamos...
				if(x>0){
					//emitimos un mensaje por consola
					System.out.println("Perfil Registrado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("Perfil No Registrado en la BD");
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
	public void update(Perfil Perfil) {
		//instanciamos la clase conectar..
		ConectarBD conex= new ConectarBD();
		
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call ActualizarPerfil(?,?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.getConexion().prepareCall(sql);
				//asignamos parametros..
				cs.setInt(1,Perfil.getIdPerfil());
				cs.setString(2,Perfil.getNombre());
				
				//ejecutamos
				int x=cs.executeUpdate();
				//aplicamos...
				if(x>0){
					//emitimos un mensaje por consola
					System.out.println("Perfil Actualizado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("Perfil No Actualizado en la BD");
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
	public void delete(Perfil Perfil) {
		
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al prodecimiento almacenado
		String sql="{call EliminarPerfil(?)}";
		//aplicamos la respectiva interface..
		CallableStatement cs=null;
		try {
			cs=conex.getConexion().prepareCall(sql);
			//asignamos los parametros
			cs.setInt(1,Perfil.getIdPerfil());
			
			//realizamos la ejecucion..
			int z=cs.executeUpdate();
			//aplicamos una condicion
			if(z>0){
				//emitimos un mensaje por pantalla
				System.out.println("Perfil Eliminado Correctamente");
				
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
	public List<Perfil> list() {
		ConectarBD conex=new ConectarBD();
		//realizamos la respectiva cadena en mysql
		String sql="call ListarPerfiles";
		//aplicamos las interfaces para base de datos
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Perfil> listado=new ArrayList<>();
		
		
		try {
			ps=conex.getConexion().prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				//instanciamos la clase classPerfil para almacenar datos de la BD..
			Perfil Perfil=new Perfil();
			Perfil.setIdPerfil(rs.getInt(1));
			Perfil.setNombre(rs.getString(2));
			
		    listado.add(Perfil);
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

}
