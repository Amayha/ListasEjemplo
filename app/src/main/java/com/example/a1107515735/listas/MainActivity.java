package com.example.a1107515735.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private Button btn_ok;
    private ListView lv_estudaintes;
    private ArrayList<String> estudiantes;
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_nombre = findViewById(R.id.et_nombre);
        btn_ok = findViewById(R.id.btn_ok);
        lv_estudaintes = findViewById(R.id.lv_estudiantes);

        estudiantes = new ArrayList<>();
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, estudiantes);

        lv_estudaintes.setAdapter(adaptador);// vincular con la lista el adaptador


        View.OnClickListener miListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et_nombre.getText().toString();
                estudiantes.add(nombre);
                adaptador.notifyDataSetChanged();
                et_nombre.setText("");

            }
        };

        btn_ok.setOnClickListener(miListener);

    }
}

