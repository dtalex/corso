package com.eng.corso.bean;

import com.eng.corso.interfaces.Mergeable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)

public class VoloBean implements Mergeable {

    @XmlAttribute(name = "id")
    private String codVolo;

    @XmlElement(name = "ETD")

    private Date etd;

    private Date std;
    private Boolean international;
    private Long estimated;
    private Long actual;


    public String getCodVolo() {
        return codVolo;
    }

    public void setCodVolo(String codVolo) {
        this.codVolo = codVolo;
    }

    public Date getEtd() {
        return etd;
    }

    public void setEtd(Date etd) {
        this.etd = etd;
    }

    public Date getStd() {
        return std;
    }

    public void setStd(Date std) {
        this.std = std;
    }

    public Boolean isInternational() {
        return international;
    }

    public void setInternational(Boolean international) {
        this.international = international;
    }

    public Long getEstimated() {
        return estimated;
    }

    public void setEstimated(Long estimated) {
        this.estimated = estimated;
    }

    public Long getActual() {
        return actual;
    }

    public void setActual(Long actual) {
        this.actual = actual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoloBean voloBean = (VoloBean) o;
        return codVolo.equals(voloBean.codVolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codVolo);
    }

    @Override
    public String toString() {
        return "VoloBean{" +
                "codVolo='" + codVolo + '\'' +
                ", etd=" + etd +
                ", std=" + std +
                ", international=" + international +
                ", expectedPassengers=" + estimated +
                ", actualPassengers=" + actual +
                '}';
    }

    public Mergeable merge(Mergeable other) {
        if (other == null) {
            throw new RuntimeException("Cannot merge null objects");
        }
        if (!(other instanceof VoloBean)) {
            throw new RuntimeException(other.getClass() + " is invalid class. " + VoloBean.class + " expected.");
        }

        VoloBean otherFlight = (VoloBean) other;

        if (otherFlight.getEtd() != null)
            etd = otherFlight.getEtd();
        if (otherFlight.getActual() != null)
            actual = otherFlight.getActual();
        if (otherFlight.getEstimated() != null)
            estimated = otherFlight.getEstimated();
        if (otherFlight.getStd() != null)
            std = otherFlight.getStd();
        if (otherFlight.isInternational() != null) {
            international = otherFlight.isInternational();
        }
        return this;
    }


}
