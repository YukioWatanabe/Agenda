package com.watanabe.agenda.model;

/**
 * Created by HP-PC on 2017-02-21.
 */

public enum StatusCompromisso {
    LONGE("Longe de atrasar"),
    PERTO("Perto de atrasar"),
    ATRASADO("Atrasado");

    private String label;

    StatusCompromisso(String label) {
        this.label = label;
    }

    public String label(){
        return this.label;
    }
}
