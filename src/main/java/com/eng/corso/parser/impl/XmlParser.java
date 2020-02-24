package com.eng.corso.parser.impl;

import com.eng.corso.bean.ListaVoli;
import com.eng.corso.parser.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class XmlParser implements Parser {

    @Override
    //uso le api jaxb per mettere i dati direttamente in dei bean
    public ListaVoli parse(InputStream is) {
        try {
            JAXBContext jContext = JAXBContext.newInstance(ListaVoli.class);
            Unmarshaller marshallObj = jContext.createUnmarshaller();

            return (ListaVoli) marshallObj.unmarshal(is);
        } catch (JAXBException j) {
            throw new RuntimeException(j.getMessage(), j);
        }
    }

}
