package com.example.ticketreader.controllers;

import com.example.ticketreader.model.Ticket;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

import java.time.Duration;
import java.util.List;
import java.util.OptionalDouble;

public class TicketController {

    public Double getAvgInSecond(List<Ticket> tickets, String originName, String destinationName) {
        OptionalDouble avg = tickets.stream()
                .filter(ticket -> ticket.getOrigin_name().equals(originName) &&
                        ticket.getDestination_name().equals(destinationName))
                .map(Ticket::getFlightDuration)
                .mapToDouble(Duration::getSeconds)
                .average();

        Duration.ofSeconds((long) avg.getAsDouble());
        return avg.getAsDouble();
    }

    public Double getPercentile(List<Ticket> tickets, double percentileValue, String originName,
                                String destinationName) {

        double[] percentileData = tickets.stream()
                .filter(ticket -> ticket.getOrigin_name().equals(originName) &&
                        ticket.getDestination_name().equals(destinationName))
                .map(Ticket::getFlightDuration)
                .mapToDouble(Duration::getSeconds)
                .toArray();

        Percentile percentile = new Percentile();
        percentile.setData(percentileData);

        return (double) Duration.ofSeconds((long) percentile.evaluate(percentileValue)).getSeconds();
    }
}
