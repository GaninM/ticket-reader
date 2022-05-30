package com.example.ticketreader.ticketJsonParser;

import com.example.ticketreader.model.TicketsHolder;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TicketsJsonParser {

    public TicketsHolder parseTickets(String path) throws IOException {
        Gson gson = new Gson();
        String jsonFile = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        return gson.fromJson(jsonFile, TicketsHolder.class);
    }
}
