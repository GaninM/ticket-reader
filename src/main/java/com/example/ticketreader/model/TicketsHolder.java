package com.example.ticketreader.model;

import java.util.List;
import java.util.StringJoiner;


public class TicketsHolder {
    private List<Ticket> tickets;

    public TicketsHolder(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TicketsHolder.class.getSimpleName() + "[", "]")
                .add("tickets=" + tickets)
                .toString();
    }
}
