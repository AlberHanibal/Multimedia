package colmenar.casas.alberto.adivinaminumeroalbertocolmenar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Puntuaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);
        TextView puntuaciones = (TextView) findViewById(R.id.viewPuntuaciones);
        StringBuffer strBuf = new StringBuffer();
        try {
            File fichero = new File("puntuaciones.txt");
            if (!fichero.exists()) {
                // se crea vacío
                FileOutputStream fos = openFileOutput("puntuaciones.txt", Context.MODE_PRIVATE | Context.MODE_APPEND);
                OutputStreamWriter out = new OutputStreamWriter(fos);
                out.write("");
                out.close();
            }
            // se lee el fichero y lo añade a puntuaciones
            FileInputStream fis = openFileInput("puntuaciones.txt");
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                strBuf.append(sc.nextLine() + "\n");
            }
            sc.close();
            puntuaciones.setText(strBuf.toString());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void botonVolver (View v) {
        finish();
    }
}
