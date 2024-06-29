package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ITarea;
import Util.ConectarBD;
import model.Perfil;
import model.Tarea;
import model.Usuario;

import java.time.LocalDate;

public class TareaImp implements ITarea{

	@Override
	public void save(Tarea Tarea) {
	
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call InsertarTarea(?,?,?,?,?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.getConexion().prepareCall(sql);
				//asignamos parametros..
				cs.setString(1,Tarea.getDescripcion());
				cs.setInt(2,Tarea.getIdEmpleado().getIdUsuario());
				cs.setString(3,Tarea.getEstado());
				cs.setDate(4,java.sql.Date.valueOf(Tarea.getFechaInicio()));
				cs.setDate(5,java.sql.Date.valueOf(Tarea.getFechaFin()));
				
				//ejecutamos
				int x=cs.executeUpdate();
				//aplicamos...
				if(x>0){
					//emitimos un mensaje por consola
					System.out.println("Tarea Registrado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("Tarea No Registrado en la BD");
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
	public void update(Tarea Tarea) {
		//instanciamos la clase conectar..
		ConectarBD conex= new ConectarBD();
		
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call ActualizarTarea(?,?,?,?,?,?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.getConexion().prepareCall(sql);
				//asignamos parametros..
				cs.setInt(1,Tarea.getIdTarea());
				cs.setString(2,Tarea.getDescripcion());
				cs.setInt(3,Tarea.getIdEmpleado().getIdUsuario());
				cs.setString(4,Tarea.getEstado());
				cs.setDate(5,java.sql.Date.valueOf(Tarea.getFechaInicio()));
				cs.setDate(6,java.sql.Date.valueOf(Tarea.getFechaFin()));
				
				//ejecutamos
				int x=cs.executeUpdate();
				//aplicamos...
				if(x>0){
					//emitimos un mensaje por consola
					System.out.println("Tarea Actualizado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("Tarea No Actualizado en la BD");
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
	public void delete(Tarea Tarea) {
		
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al prodecimiento almacenado
		String sql="{call EliminarTarea(?)}";
		//aplicamos la respectiva interface..
		CallableStatement cs=null;
		try {
			cs=conex.getConexion().prepareCall(sql);
			//asignamos los parametros
			cs.setInt(1,Tarea.getIdTarea());
			
			//realizamos la ejecucion..
			int z=cs.executeUpdate();
			//aplicamos una condicion
			if(z>0){
				//emitimos un mensaje por pantalla
				System.out.println("Tarea Eliminado Correctamente");
				
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
	public List<Tarea> list() {
		ConectarBD conex=new ConectarBD();
		//realizamos la respectiva cadena en mysql
		String sql="call ListarTareas";
		//aplicamos las interfaces para base de datos
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Tarea> listado=new ArrayList<>();
		
		
		try {
			ps=conex.getConexion().prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				//instanciamos la clase classTarea para almacenar datos de la BD..
			Tarea Tarea=new Tarea();
			Tarea.setIdTarea(rs.getInt(1));
			Tarea.setDescripcion(rs.getString(2));
			Tarea.setEstado(rs.getString(3));
			Tarea.setFechaInicio(rs.getDate(4).toLocalDate());
			Tarea.setFechaFin(rs.getDate(5).toLocalDate());
			
			Usuario empleado=new Usuario(); 
			empleado.setIdUsuario(rs.getInt(6));
			empleado.setNombreCompleto(rs.getString(7));
			
			Tarea.setIdEmpleado(empleado);
			
		    listado.add(Tarea);
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
