package com.example.adivinaminumeroalbertocolmenar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puntuaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);
        TextView puntuaciones = (TextView) findViewById(R.id.viewPuntuaciones);
        StringBuffer strBuf = new StringBuffer();
        try {
            FileInputStream fis = openFileInput("puntuaciones.txt");
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                strBuf.append(sc.nextLine() + "\n");
            }
            sc.close();
            puntuaciones.setText(strBuf.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void botonVolver (View v) {
        finish();
    }
}