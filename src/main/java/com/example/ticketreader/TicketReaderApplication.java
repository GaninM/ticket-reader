package com.example.ticketreader;

import com.example.ticketreader.controllers.TicketController;
import com.example.ticketreader.model.Ticket;
import com.example.ticketreader.ticketJsonParser.TicketsJsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TicketReaderApplication {

    public static void main(String[] args) {
        String absolutePath = new File("").getAbsolutePath();
        TicketsJsonParser ticketsJsonParser = new TicketsJsonParser();
        List<Ticket> allTickets = new ArrayList<>();
        TicketController ticketController = new TicketController();
        String path = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Введите путь к файлу:");
                System.out.println("Можете выбрать файл из задания введя ticket");
                try {
                    path = reader.readLine();
                    if (path.equals("ticket")) {
                        allTickets = ticketsJsonParser.parseTickets(absolutePath + "//src//main//resources//tickets.json").getTickets();
                    } else {
                        allTickets = ticketsJsonParser.parseTickets(path).getTickets();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Файл по пути " + path + "не найден");
                }
            }

            System.out.println("Среднее время полета между городами Владивосток и Тель-Авив составляет - " +
                    ticketController.getAvgInSecond(allTickets, "Владивосток", "Тель-Авив") +
                    " секунд");
            System.out.println("90-й процентиль времени полета между городами Владивосток и Тель-Авив составляет - " +
                    ticketController.getPercentile(allTickets, 90, "Владивосток",
                            "Тель-Авив") + " секунд");

        } catch (Exception e) {
            System.out.println("last");
            e.getStackTrace();
        }
    }
}
