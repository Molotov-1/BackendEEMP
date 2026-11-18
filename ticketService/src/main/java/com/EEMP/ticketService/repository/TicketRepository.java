package com.EEMP.ticketService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EEMP.ticketService.model.Tickets;
import java.util.List;

public interface TicketRepository extends JpaRepository<Tickets, Long> {
    List<Tickets> findBySolicitanteId(Long solicitanteId);
    List<Tickets> findByAsignadoId(Long asignadoId);
    List<Tickets> findByEstado(String estado);
}