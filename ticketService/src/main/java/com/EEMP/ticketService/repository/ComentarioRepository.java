package com.EEMP.ticketService.repository;

import com.EEMP.ticketService.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByTicketId(Long ticketId);
}