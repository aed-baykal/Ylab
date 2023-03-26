package org.example.dated.map;

import java.util.Date;

public class DatedMapElement {

    private final Date date;
    private final String value;

    public DatedMapElement(Date date, String value) {
        this.date = date;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

}
