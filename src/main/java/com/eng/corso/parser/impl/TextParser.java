package com.eng.corso.parser.impl;

import com.eng.corso.bean.ListaVoli;
import com.eng.corso.bean.VoloBean;
import com.eng.corso.parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;

public class TextParser implements Parser {

    @Override
    public ListaVoli parse(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String line;
        ListaVoli list = new ListaVoli();
        Set<VoloBean> voli = list.getData();
        while ((line = br.readLine()) != null) {
            VoloBean volo = new VoloBean();
            volo.setCodVolo(line.substring(0, 7));
            //aggiungo 3 zeri alla data passatami che e in secondi mentre io mi aspetto i millisecondi
            Date d = new Date(Long.parseLong(line.substring(7, 17)) * 1000);
            volo.setStd(d);
            volo.setInternational(Boolean.parseBoolean(line.substring(17)));
            voli.add(volo);
        }
        return list;
    }
}
