package com.eng.corso.parser;

import com.eng.corso.bean.ListaVoli;

import java.io.IOException;
import java.io.InputStream;

// Strategy Pattern
public interface Parser {
    ListaVoli parse(InputStream is) throws IOException;
}
