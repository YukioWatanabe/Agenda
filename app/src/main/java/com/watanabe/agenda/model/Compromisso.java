package com.watanabe.agenda.model;

import java.util.Date;
import java.util.List;

public class Compromisso {
    public String titulo;
    public String descricao;
    public Date data;
    public Date dataFim;
    public List<Integer> diasSemana;
    public Long horaAviso;
    public StatusCompromisso status;
    public boolean feito;

    public Compromisso(){}

    public Compromisso(StatusCompromisso status, String titulo, Date data){
        this.status = status;
        this.titulo = titulo;
        this.data = data;
    }
}
