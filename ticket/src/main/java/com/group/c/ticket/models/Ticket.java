package com.group.c.ticket.models;

import org.yaml.snakeyaml.events.Event;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.group.c.ticket.Enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private String userID;
    private String ticketId;
    private String qrCodeId;

    private Event event;

    private Status status; 

    private String eventId;
    private String eventName;

}
