package com.springboot.ticket.controller;

import com.springboot.ticket.entity.Ticket;
import com.springboot.ticket.exception.ResourceNotFoundException;
import com.springboot.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return this.ticketRepository.findAll();
    }

    // get ticket by its id
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable (value = "id") long id) {
        return this.ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found id: " + id));
    }

    // get tickets by user id
    @GetMapping("/user/{id}")
    public List<Ticket> getByUserId(@PathVariable (value = "id") long id) {
        return this.ticketRepository.findByUserId(id);
    }

    // create ticket
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return this.ticketRepository.save(ticket);
    }

    // update ticket
    @PutMapping("/{id}")
    public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable ("id") long id) {
        Ticket currTicket = this.ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found id: " + id));
        currTicket.setName(ticket.getName());
        currTicket.setUserId(ticket.getUserId());
        return this.ticketRepository.save(currTicket);
    }

    // delete ticket by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable ("id") long id){
        Ticket existingTicket = this.ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found id: " + id));
        this.ticketRepository.delete(existingTicket);
        return ResponseEntity.ok().build();
    }
}