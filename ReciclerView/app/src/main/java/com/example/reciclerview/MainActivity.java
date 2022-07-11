package com.example.reciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvLista;
    private adaptadorRecicler adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controles();
        llenarRecycler();
    }
    private void controles() {
        rvLista = findViewById(R.id.rv_item);
    }

    private void llenarRecycler() {

        List<ModeloPersona> modeloP = new ArrayList<>();

        ModeloPersona p1 = new ModeloPersona("Juan",0);
        modeloP.add(p1);

        modeloP.add(new ModeloPersona("raul",0));
        modeloP.add(new ModeloPersona("luis",0));
        modeloP.add(new ModeloPersona("luis2",0));
        modeloP.add(new ModeloPersona("luis3",0));
        modeloP.add(new ModeloPersona("luis4",0));
        modeloP.add(new ModeloPersona("luis5",0));
        modeloP.add(new ModeloPersona("luis6",0));
        modeloP.add(new ModeloPersona("luis7",0));
        modeloP.add(new ModeloPersona("luis8",0));
        modeloP.add(new ModeloPersona("luis9",0));
        modeloP.add(new ModeloPersona("luis10",0));
        modeloP.add(new ModeloPersona("luis11",0));
        modeloP.add(new ModeloPersona("luis12",0));
        modeloP.add(new ModeloPersona("luis13",0));



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(layoutManager);
        adapter = new adaptadorRecicler(modeloP);
        rvLista.setAdapter(adapter);

    }
}