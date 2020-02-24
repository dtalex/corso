//ho rimosso per errore i timezone dall'xml quindi devo aggiungere un'ora per riallinearmi con il fuso orario
//questo viene fatto nella classe date adapter (errore mio non era voluto)

@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type = Date.class,
                value = DateAdapter.class)
})


package com.eng.corso.bean;

import com.eng.corso.util.DateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.util.Date;

