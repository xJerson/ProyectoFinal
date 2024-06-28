package Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Dao.ProyectoImp;
import Dto.ProyectoDTO;
import Dto.ProyectoDTOSTRING;
import adapter.LocalDateAdapter;
import adapter.LocalDateTimeAdapter;
import model.Proyecto;
import model.Usuario;



@Path("/proyectos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProyectoResource {

    private ProyectoImp crud = new ProyectoImp();

    @GET
    @Path("/listar")
    public Response listarProyectos() {
        List<Proyecto> proyectos = crud.ListProyectos();

        if (proyectos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontró ningún proyecto").build();
        } else {
        	
        	 
        	List<ProyectoDTO> proyectoDTOs = proyectos.stream()
                    .map(proyecto -> new ProyectoDTO.Builder()
                            .nombre(proyecto.getNombre())
                            .descripcion(proyecto.getDescripcion())
                            .fechaInicio(proyecto.getFechaInicio())
                            .fechaFin(proyecto.getFechaFin())
                            .estado(proyecto.getEstado())
                            .fechaRegistro(proyecto.getFechaRegistro())
                            .build())
                    .collect(Collectors.toList());

            // Configurar Gson con adaptadores para LocalDate y LocalDateTime
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            String proyectosJson = gson.toJson(proyectoDTOs);

            return Response.ok(proyectosJson).build();
        }
    }
    
    
    @POST
    @Path("/registrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarProyecto(ProyectoDTOSTRING proyectoDto){
        Proyecto proyecto = convertirDtoAEntidad(proyectoDto); // Convertir DTO a entidad
        crud.saveProyecto(proyecto);
        return Response.status(Response.Status.CREATED)
                .entity("EL Proyecto " + proyecto.getNombre()+ " Se ha registrado Correctamente").build();
    }

    // Método para convertir DTO ProyectoDTOSTRING a entidad Proyecto
    private Proyecto convertirDtoAEntidad(ProyectoDTOSTRING proyectoDTO) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setFechaInicio(LocalDate.parse(proyectoDTO.getFechaInicio())); // Convertir String a fecha
        proyecto.setFechaFin(LocalDate.parse(proyectoDTO.getFechaFin()));       // Convertir String a fecha
        proyecto.setEstado(proyectoDTO.getEstado());
        proyecto.setUsuarioRegistro(proyectoDTO.getUsuarioRegistro()); 
        return proyecto;
    }
    
}
