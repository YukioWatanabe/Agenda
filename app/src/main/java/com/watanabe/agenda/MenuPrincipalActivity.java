package com.watanabe.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuPrincipalActivity extends AppCompatActivity {

    private String[] listaCompromissisos = {
        "Tomar café da manhã",
        "Sair pra trabalhar",
        "Almoçar",
        "Voltar para trabalhar",
        "Sair do trabalho",
        "Estudar",
        "Dormir"
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
        ArrayAdapter<String> listaCompromissosAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.sample_text,
                android.R.id.text1,
                listaCompromissisos
        );

        listViewCompromissos.setAdapter(listaCompromissosAdapter);
    }
}
