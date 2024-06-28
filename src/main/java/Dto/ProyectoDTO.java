package Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;



public class ProyectoDTO {
    private final String nombre;
    private final String descripcion;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final String estado;
    private final LocalDateTime fechaRegistro;

    private ProyectoDTO(Builder builder) {
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.fechaInicio = builder.fechaInicio;
        this.fechaFin = builder.fechaFin;
        this.estado = builder.estado;
        this.fechaRegistro = builder.fechaRegistro;
    }

    public static class Builder {
        private String nombre;
        private String descripcion;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        private String estado;
        private LocalDateTime fechaRegistro;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder fechaInicio(LocalDate fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public Builder fechaFin(LocalDate fechaFin) {
            this.fechaFin = fechaFin;
            return this;
        }

        public Builder estado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder fechaRegistro(LocalDateTime fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public ProyectoDTO build() {
            return new ProyectoDTO(this);
        }
    }

 
}
