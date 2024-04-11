package com.group.c.ticket.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.group.c.ticket.models.Ticket;
import com.group.c.ticket.repository.Temp;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {

    private Temp temp = new Temp();
    
    @PostMapping("/post")
    public ResponseEntity<Ticket> postTicket(@RequestBody Ticket payload) {
        
        payload.setEventId(String.valueOf(payload.getEvent().getEventId().toString()));
        
        //add to repository
        temp.getTickets().add(payload);

        return ResponseEntity.ok(payload);
    }

    @GetMapping("/get")
    public ResponseEntity<Ticket> getTicket(@RequestParam String ticketId) {
        
        // fetch from repository the ticket with the given ticketId
        Ticket ticket = temp.getTickets().stream().filter(t -> t.getTicketId().equals(ticketId)).findFirst().orElse(null);

        if(ticket == null) {
            return ResponseEntity.status(Response.SC_NOT_FOUND).build();
        }

        return ResponseEntity.ok(ticket);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable String ticketId) {
        
        // fetch from repository the ticket with the given ticketId
        Ticket ticket = temp.getTickets().stream().filter(t -> t.getTicketId().equals(ticketId)).findFirst().orElse(null);

        if(ticket == null) {
            return ResponseEntity.status(Response.SC_NOT_FOUND).build();
        }

        temp.getTickets().remove(ticket);

        return ResponseEntity.ok("Ticket deleted successfully");
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable String id, @RequestBody Ticket payload) {
        
        Ticket ticket = temp.getTickets().stream().filter(t -> t.getTicketId().equals(id)).findFirst().orElse(null);
        

        if(ticket == null) {
            return ResponseEntity.status(Response.SC_NOT_FOUND).build();
        }

        ticket = payload;

        return ResponseEntity.ok("Ticket updated successfully");
    }
}
