package com.eng.corso.parser;

import com.eng.corso.parser.impl.JsonParser;
import com.eng.corso.parser.impl.TextParser;
import com.eng.corso.parser.impl.XmlParser;

public class ParserFactory {
    public static Parser getParser(ParserType type) {
        switch (type) {
            case JSON:
                return new JsonParser();
            case XML:
                return new XmlParser();
            case TEXT:
            default:
                return new TextParser();
        }
    }
}
