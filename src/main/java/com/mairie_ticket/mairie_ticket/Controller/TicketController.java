package com.mairie_ticket.mairie_ticket.Controller;


import com.mairie_ticket.mairie_ticket.model.Ticket;
import com.mairie_ticket.mairie_ticket.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket creerTicket(@RequestParam String nomFemme) {
        return ticketService.creerTicket(nomFemme);
    }

    @GetMapping("/jour")
    public List<Ticket> ticketsDuJour() {
        return ticketService.ticketsDuJour();
    }
}