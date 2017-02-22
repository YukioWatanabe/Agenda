package com.watanabe.agenda.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.watanabe.agenda.R;
import com.watanabe.agenda.adapters.CompromissoAdapter;
import com.watanabe.agenda.model.Compromisso;
import com.watanabe.agenda.model.StatusCompromisso;

import java.util.Date;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Compromisso[] listaCompromissisos = {
        new Compromisso(StatusCompromisso.LONGE, "Tomar café da manhã", new Date()),
        new Compromisso(StatusCompromisso.PERTO, "Sair pra trabalhar", new Date()),
        new Compromisso(StatusCompromisso.ATRASADO, "Almoçar", new Date()),
        new Compromisso(StatusCompromisso.LONGE, "Voltar para trabalhar", new Date()),
        new Compromisso(StatusCompromisso.PERTO, "Sair do trabalho", new Date()),
        new Compromisso(StatusCompromisso.LONGE, "Estudar", new Date()),
        new Compromisso(StatusCompromisso.ATRASADO, "Dormir", new Date()),
    };

    private ListView listViewCompromissos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        configuraListaCompromissos();
    }

    private void configuraListaCompromissos() {
        listViewCompromissos = (ListView) findViewById(R.id.lista_compromissos);
        ArrayAdapter<Compromisso> listaCompromissosAdapter = new CompromissoAdapter(getApplicationContext(),listaCompromissisos);

        listViewCompromissos.setAdapter(listaCompromissosAdapter);
    }
}
