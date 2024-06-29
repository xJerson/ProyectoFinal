package Resource;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.core.MediaType;

import Dao.PerfilImp;
import adapter.LocalDateTimeAdapter;
import model.Perfil;


@Path("/Perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {

    private PerfilImp crudPerfil = new PerfilImp();

    @GET
    @Path("/listar")
    public Response listarPerfils() {
        List<Perfil> Perfils = crudPerfil.list();

        if (Perfils.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron Perfils").build();
        } else {
            // Configurar Gson con adaptador para LocalDateTime
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            // Serializar la lista de Perfils a JSON usando Gson
            String PerfilsJson = gson.toJson(Perfils);

            return Response.ok(PerfilsJson).build();
        }
    }
    
    @POST
    @Path("/registrar")
    public Response registrarPerfil(Perfil Perfil) {        
        crudPerfil.save(Perfil);
        return Response.status(Status.CREATED).entity("Perfil registrado exitosamente.").build();
    }

    @PUT
    @Path("/actualizar/{id}")
    public Response actualizarPerfil(@PathParam("id") int id, Perfil Perfil) {
        Perfil.setIdPerfil(id);
        crudPerfil.update(Perfil);
        return Response.ok("Perfil actualizado exitosamente.").build();
    }

    @DELETE
    @Path("/eliminar/{id}")
    public Response eliminarPerfil(@PathParam("id") int id) {
        Perfil Perfil = new Perfil();
        Perfil.setIdPerfil(id);
        crudPerfil.delete(Perfil);
        return Response.ok("Perfil eliminado exitosamente.").build();
    }    
}