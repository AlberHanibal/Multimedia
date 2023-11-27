package colmenar.casas.alberto.applibrodevisitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private final static String NOMBRE_FICHERO = "visitantes.txt";
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.etNombre);
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.KEYCODE_ENTER)) {
                    onNuevoNombre();
                    return true;
                }
                return false;
            }
        });

        actualizarVisitantes();
    }

    protected void onNuevoNombre() {
        String nuevoNombre = et.getText().toString();
        if (nuevoNombre.trim().equals("")) {
            muestraMensaje(R.string.errorNombre);
        } else {
            try {
                FileOutputStream fos;
                fos = openFileOutput(NOMBRE_FICHERO, Context.MODE_PRIVATE | Context.MODE_APPEND);
                OutputStreamWriter out = new OutputStreamWriter(fos);
                out.write(nuevoNombre + "\n");
                out.close();
                muestraMensaje(R.string.bienvenido);
                actualizarVisitantes();
            } catch (IOException e) {
                muestraMensaje(R.string.errorRegistro);
            }
        }
        et.requestFocus();
        et.setText("");
    }

    protected void actualizarVisitantes() {
        StringBuffer strBuf = new StringBuffer();
        TextView tv = (TextView) findViewById(R.id.etVisitantes);
        try {
            FileInputStream fis = openFileInput(NOMBRE_FICHERO);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                strBuf.append(sc.nextLine() + "\n");
            }
            sc.close();
            tv.setText(strBuf.toString());
        } catch (IOException e) {
            muestraMensaje(R.string.errorVisitantes);
        }
    }

    protected void muestraMensaje(int id) {
        String mensaje = getResources().getString(id);
        Toast t = Toast.makeText(this, mensaje, Toast.LENGTH_LONG);
        t.show();
    }




}