package com.mairie_ticket.mairie_ticket.service;

import com.mairie_ticket.mairie_ticket.model.Ticket;
import com.mairie_ticket.mairie_ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket creerTicket(String nomFemme) {
        Ticket ticket = new Ticket();
        ticket.setNomFemme(nomFemme);
        ticket.setMontant(200); // si c’est toujours 200 FCFA
        ticket.setDate(LocalDate.now()); // par exemple
        return ticketRepository.save(ticket);
    }


    public List<Ticket> ticketsDuJour() {
        return ticketRepository.findByDate(LocalDate.now());
    }
}