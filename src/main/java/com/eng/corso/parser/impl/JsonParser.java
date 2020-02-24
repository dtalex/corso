package com.eng.corso.parser.impl;


import com.eng.corso.bean.ListaVoli;
import com.eng.corso.parser.Parser;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JsonParser implements Parser {
    //uso le api GSON per fare il parsing del json direttametne nel bean
    public ListaVoli parse(InputStream is) throws IOException {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        return gson.fromJson(br, ListaVoli.class);
    }
}
