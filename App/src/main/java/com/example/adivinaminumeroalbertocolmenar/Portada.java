package com.example.adivinaminumeroalbertocolmenar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Portada extends AppCompatActivity {

    EditText cajaNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
        cajaNombre = findViewById(R.id.cajaNombre);
    }

    public void botonJugar(View v) {
        String nombre = cajaNombre.getText().toString();
        if (!nombre.equals("")) {
            Intent i = new Intent (this, MainActivity.class);
            i.putExtra("nombre", nombre);
            startActivity(i);
        } else {
            Context contexto = getApplicationContext();
            int duracion = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto, R.string.errorNombre, duracion);
            toast.show();
        }
    }

    public void botonPuntuaciones(View v) {
        Intent i = new Intent (this, Puntuaciones.class);
        startActivity(i);
    }
}
