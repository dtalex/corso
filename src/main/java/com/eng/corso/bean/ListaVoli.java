package com.eng.corso.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaVoli {
    @XmlElement(name = "volo")
    private Set<VoloBean> data;

    public synchronized Set<VoloBean> getData() {

        if (data == null) {
            data = new HashSet<>();
        }
        return data;
    }


    @Override
    public String toString() {
        return "ListaVoli{" +
                "volo=" + data +
                '}';
    }
}
