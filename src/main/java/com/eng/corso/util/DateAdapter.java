package com.eng.corso.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter
        extends XmlAdapter<String, Date> {

    public Date unmarshal(String v) throws Exception {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //aggiungo un'ora alla data dell'xml
        return new Date(sf.parse(v).getTime() + 1000 * 60 * 60);
    }

    public String marshal(Date v) throws Exception {
        return v.toString();
    }

}
