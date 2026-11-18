package com.EEMP.ticketService.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;
    private Long autorId;

    @Column(columnDefinition = "TEXT")
    private String texto;

    private LocalDateTime fecha = LocalDateTime.now();
}