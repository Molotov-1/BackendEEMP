package com.EEMP.ticketService.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private Long categoriaId;
    private Long ubicacionId;
    private Long solicitanteId;
    private Long asignadoId;

    private String prioridad; // BAJA, MEDIA, ALTA, URGENTE
    private String estado;    // PENDIENTE, REVISADO, ASIGNADO, EN_PROCESO, SOLUCIONADO, CERRADO, CANCELADO

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    private String fotoUrl;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
        if (this.estado == null) this.estado = "PENDIENTE";
        if (this.prioridad == null) this.prioridad = "MEDIA";
        if (this.codigo == null) {
            this.codigo = "TKT-" + System.currentTimeMillis();
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }
}