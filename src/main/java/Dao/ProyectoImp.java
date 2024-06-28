package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Interfaces.IProyecto;
import Util.ConectarBD;
import model.Perfil;
import model.Proyecto;
import model.Usuario;

public class ProyectoImp implements IProyecto{

	@Override
	public void saveProyecto(Proyecto proyecto) {
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call InsertarProyecto(?,?,?,?,?,?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.getConexion().prepareCall(sql);
				//asignamos parametros..
				cs.setString(1,proyecto.getNombre());
				cs.setString(2,proyecto.getDescripcion());
				
				// Convertir LocalDate a java.sql.Date
	            cs.setDate(3, java.sql.Date.valueOf(proyecto.getFechaInicio()));
	            cs.setDate(4, java.sql.Date.valueOf(proyecto.getFechaFin()));
	            
				cs.setString(5,proyecto.getEstado());
				cs.setInt(6,proyecto.getUsuarioRegistro().getIdUsuario());
				
				
				
				//ejecutamos
				int rowsAffected =cs.executeUpdate();
				//aplicamos...
				if(rowsAffected >0){
					//emitimos un mensaje por consola
					System.out.println("Proyecto Registrado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("Proyecto No Registrado en la BD");
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
	public void updateProyecto(Proyecto proyecto) {
		//instanciamos la clase conectar..
				ConectarBD conex= new ConectarBD();
				
				//realizamos la cadena o invocamos al procedimiento almacenado
				String sql="{call ActualizarUsuario(?,?,?,?,?,?,?)}";
				//aplicamos la interface callablestatement....
				CallableStatement cs=null;
				//asignamos a la conexion y el p.a.
				
					try {
						cs=conex.getConexion().prepareCall(sql);
						//asignamos parametros..
						cs.setInt(1,proyecto.getIdProyecto());
						cs.setString(2,proyecto.getNombre());
						cs.setString(3,proyecto.getDescripcion());
						
						// Convertir LocalDate a java.sql.Date
			            cs.setDate(4, java.sql.Date.valueOf(proyecto.getFechaInicio()));
			            cs.setDate(5, java.sql.Date.valueOf(proyecto.getFechaFin()));
						
						cs.setString(6,proyecto.getEstado());
						cs.setInt(7,proyecto.getUsuarioRegistro().getIdUsuario());
						
						//ejecutamos
						int rowsAffected=cs.executeUpdate();
						//aplicamos...
						if(rowsAffected>0){
							//emitimos un mensaje por consola
							System.out.println("Proyecto Actualizado en la BD EXITOSAMENTE");
						}
						else{
							System.out.println("Proyecto No Actualizado en la BD");
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
	public void deleteProyecto(Proyecto proyecto) {
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al prodecimiento almacenado
		String sql="{call EliminarProyecto(?)}";
		//aplicamos la respectiva interface..
		CallableStatement cs=null;
		try {
			cs=conex.getConexion().prepareCall(sql);
			//asignamos los parametros
			cs.setInt(1,proyecto.getIdProyecto());
			
			//realizamos la ejecucion..
			int rowsAffected=cs.executeUpdate();
			//aplicamos una condicion
			if(rowsAffected>0){
				//emitimos un mensaje por pantalla
				System.out.println("Proyecto Eliminado Correctamente");
				
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
	public Proyecto obtenerProyecto(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> ListProyectos() {
		ConectarBD conex=new ConectarBD();
		//realizamos la respectiva cadena en mysql
		String sql="call ListarProyectos";
		//aplicamos las interfaces para base de datos
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Proyecto> listado=new ArrayList<>();
		
		
		try {
			ps=conex.getConexion().prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				//instanciamos la clase classusuario para almacenar datos de la BD..
			Proyecto proyecto=new Proyecto();
			proyecto.setNombre(rs.getString(1));
			proyecto.setDescripcion(rs.getString(2));
			proyecto.setFechaInicio(rs.getDate(3).toLocalDate());
			proyecto.setFechaFin(rs.getDate(4).toLocalDate());
			proyecto.setEstado(rs.getString(5));
			
            Timestamp timestampRegistro = rs.getTimestamp(6);
            if (timestampRegistro != null) {
                proyecto.setFechaRegistro(timestampRegistro.toLocalDateTime());
            }

  
            
		    listado.add(proyecto);
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
	public boolean existProyecto(int id) {
		ConectarBD conex = new ConectarBD();
	    Connection con = null;
	    CallableStatement cs = null;
	    boolean existe = false;

	    try {
	        con = conex.getConexion();
	        String sql = "{call existeProyecto(?)}"; 
	        cs = con.prepareCall(sql);
	        cs.setInt(1, id);
	        cs.execute();

	       
	        ResultSet rs = cs.getResultSet();
	        if (rs.next()) {
	            existe = rs.getBoolean("proyecto_existe");
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
