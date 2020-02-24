package com.eng.corso;

import com.eng.corso.bean.ListaVoli;
import com.eng.corso.bean.VoloBean;
import com.eng.corso.parser.Parser;
import com.eng.corso.parser.ParserFactory;
import com.eng.corso.parser.ParserType;
import com.eng.corso.util.MergeableHashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.text.StringEscapeUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // creop i parser dal factory
        Parser xmlParser = ParserFactory.getParser(ParserType.XML);
        Parser textParser = ParserFactory.getParser(ParserType.TEXT);
        Parser jsonParser = ParserFactory.getParser(ParserType.JSON);

        ListaVoli xmlFlights, jsonFlights, textFlights;

        //Faccio il parsing degli input mettendo tutto nel bean ListaVoli

        try (InputStream is = new FileInputStream(new File("handler.xml"))) {
            //Per fare il parsing dell'xml uso le annotazioni jaxb
            xmlFlights = xmlParser.parse(is);
        }

        try (InputStream is = new FileInputStream(new File("passengers.json"))) {
            //il parsing json avviene tramite nomi dei campi
            jsonFlights = jsonParser.parse(is);
        }

        try (InputStream is = new FileInputStream(new File("bdv.dat"))) {
            //faccio il parsing dello stringone
            textFlights = textParser.parse(is);
        }


        //metto tutti i miei voli in una una mappa in base codvolo
        //la put della mappa fa il merge in caso di collisione
        Map<String, VoloBean> flights = new MergeableHashMap<>();
        xmlFlights.getData().forEach(curVolo -> flights.put(curVolo.getCodVolo(), curVolo));
        jsonFlights.getData().forEach(curVolo -> flights.put(curVolo.getCodVolo(), curVolo));
        textFlights.getData().forEach(curVolo -> flights.put(curVolo.getCodVolo(), curVolo));


        //creo il file di output a partire dal template
        String template = readFileContent("template.html");

        Gson gs = new GsonBuilder()
                .setDateFormat("Y-MM-dd HH:mm").create();
        //non voglio tornare direttamente l'html come abbiamo fatto in aula. ci pensera poi il javascript a mostrare i dati
        //trasformo i bean in json forzando il formato data desiderato
        template = template.replaceAll("#JSON#", StringEscapeUtils.escapeEcmaScript(gs.toJson((flights.values()))));

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.html"));
        writer.write(template);

        writer.close();
    }

    private static String readFileContent(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
