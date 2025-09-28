package com.mairie_ticket.mairie_ticket.repository;

import com.mairie_ticket.mairie_ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByDate(LocalDate date);
}