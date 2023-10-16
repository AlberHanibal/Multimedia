package colmenar.alberto.appadivina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int numeroOculto;
    private int numeroJugado;
    private int numIntentos;
    EditText et = null;
    TextView textoIzq = null;
    TextView textoIntentos = null;
    Button botonProbar = null;
    Button botonVolverAJugar = null;
    TextView textoVolverAJugar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.cajaTexto);
        textoIzq = (TextView) findViewById(R.id.textoIzq);
        textoIntentos = (TextView) findViewById(R.id.textoIntentos);
        botonProbar = (Button) findViewById(R.id.botonProbar);
        botonVolverAJugar = (Button) findViewById(R.id.botonVolverAJugar);
        botonVolverAJugar.setVisibility(View.INVISIBLE);
        textoVolverAJugar = (TextView) findViewById(R.id.textoVolverAJugar);
        textoVolverAJugar.setVisibility(View.INVISIBLE);

        crearNumeroAleatorio();
        et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == android.view.KeyEvent.ACTION_DOWN) && (keyCode == android.view.KeyEvent.KEYCODE_ENTER)) {
                    probar(v);
                    return true;
                } else return false;
            }
        });
    }
    private void crearNumeroAleatorio() {
        numIntentos = 0;
        Random dado = new Random();
        numeroOculto = dado.nextInt(100) + 1;
    }
    public void probar(View v) {
        String mensaje;
        String mensajeFinal;
        System.out.println(numeroOculto);
        numeroJugado = Integer.parseInt(et.getText().toString());
        if (numeroJugado > numeroOculto) {
            mensaje = getResources().getString(R.string.textoMenor);
            mensajeFinal = String.format(mensaje, numeroJugado);
        } else if (numeroJugado < numeroOculto) {
            mensaje = getResources().getString(R.string.textoMayor);
            mensajeFinal = String.format(mensaje, numeroJugado);
        } else {
            finalPartida();
            mensajeFinal = getResources().getString(R.string.textoAcierto);
        }
        textoIzq.setText(mensajeFinal);
        et.setText("");
        actualizarIntentos();
    }
    private void actualizarIntentos() {
        numIntentos++;
        String texto = getResources().getQuantityString(R.plurals.intentos, numIntentos, numIntentos);
        textoIntentos.setText(texto);
    }
    private void finalPartida() {
        botonVolverAJugar.setVisibility(View.VISIBLE);
        textoVolverAJugar.setVisibility(View.VISIBLE);
        et.setVisibility(View.INVISIBLE);
        botonProbar.setVisibility(View.INVISIBLE);
        textoIzq.setVisibility(View.INVISIBLE);
        textoIntentos.setVisibility(View.INVISIBLE);
    }
    public void jugar(View v) {
        crearNumeroAleatorio();
        botonVolverAJugar.setVisibility(View.INVISIBLE);
        textoVolverAJugar.setVisibility(View.INVISIBLE);
        et.setVisibility(View.VISIBLE);
        botonProbar.setVisibility(View.VISIBLE);
        textoIzq.setVisibility(View.VISIBLE);
        textoIntentos.setVisibility(View.VISIBLE);
        textoIzq.setText(R.string.textoIzq);
        textoIntentos.setText("");
    }
}