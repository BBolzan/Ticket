package com.group.c.ticket.repository;

import java.util.ArrayList;
import java.util.List;

import com.group.c.ticket.models.Ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Temp {
    private List<Ticket> tickets = new ArrayList<Ticket>();
}
